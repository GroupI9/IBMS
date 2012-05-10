/*
 * In this class, the constructor is given a route_id. In addition, hard coded into the class is the
 * current date and time, formatted to the functions needed by the database.
 *
 * In terms of the functionallity, the route_id along with the current date/time is used to
 * find the next service for that route, today, in the roster. It then sets that service as unavailable.
 *
 * The method returns true, if it has completed that, and false if otherwise.
 *
 * An instance must be created with that. 
 *
 *
 *
 *
 *
 */
package ibms;

import java.util.*;
import ibms.*;
import ibms.wrappers.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class cancelService
{
  private Calendar startDate;
  private int day_of_week;
  private int timing_point = 0;
  private int route_id;
  private int[] roster_id;
  
  public cancelService(int route)
  {
    database.openBusDatabase();
    Calendar cal = Calendar.getInstance();
    route_id = route;

    timing_point += cal.get(Calendar.HOUR_OF_DAY) * 60;
    timing_point += cal.get(Calendar.MINUTE);
    startDate = (Calendar)cal.clone();
    if(startDate.get(Calendar.DAY_OF_WEEK) > 1 && startDate.get(Calendar.DAY_OF_WEEK) < 7)
        day_of_week = 0;
    else if(startDate.get(Calendar.DAY_OF_WEEK) == 7)
        day_of_week = 1;
    else
        day_of_week = 2;
    
  }

  public boolean cancel()
  {
    int bus_stop_id = database.busDatabase.find_id("path_id", "path", "route", route_id, "sequence", 1);
    int daily_timetable_id = database.busDatabase.find_id("daily_timetable_id", "daily_timetable", "kind", day_of_week, "route", route_id);
    int[] service_ids = database.busDatabase.select_ids("service", "timetable_line", "timing_point", bus_stop_id, "daily_timetable", daily_timetable_id, "service");
    int[] times = new int[service_ids.length];
    int i;

    for(i = 0; i < times.length;i++)
    {
      times[i] = database.busDatabase.find_id("time", "timetable_line", "service", service_ids[i], "timing_point", bus_stop_id);
    }
    i = 0;
    int next = 0;
    while(times[i] < timing_point)
    {
      next = times[i];
      i++;
    }

    if(next != 0)
      roster_id = database.busDatabase.select_ids("roster_id", "roster", "service_id", service_ids[i], "roster_id");
    else
      return false;

    for(i = 0; i < roster_id.length; i++)
      database.busDatabase.set_value("roster", roster_id[i], "running", 0);
    return true;
  }
}
