package ibms;

import java.util.*;
import ibms.*;
import ibms.wrappers.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class timeInfo
{

  private Calendar startDate;
  private int[] rosterIDs;
  private int daily_timetable_id;
  private int[] service_ids;
  private int running;
  private int day_of_week;
  private int timing_point = 0;
  private int bus_stop;
  private int route_id;
  private String time;
  private int thisService = 0;
  private Date toDate;
  
  public timeInfo(int route, int stop)
  {
    database.openBusDatabase();
    Calendar cal = Calendar.getInstance();
    route_id = route;
    bus_stop = stop;
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

  public String[] getTimes()
  {

    String times[] = new String[5];

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    dateFormat.format(startDate.getTime());
    String yeah = startDate.getTime().toString();
    toDate = startDate.getTime();
    try{
    toDate = dateFormat.parse(yeah);}
    catch(Exception e){}

    if(!rosterExists(toDate))
      System.exit(0);

    daily_timetable_id = database.busDatabase.find_id("daily_timetable_id", "daily_timetable", "kind", day_of_week, "route", route_id);
    service_ids = database.busDatabase.select_ids("service", "timetable_line", "timing_point", bus_stop, "daily_timetable", daily_timetable_id, "service");
    if (service_ids.length == 0)
      times = getAverage();
    else
    {
    int enough = 0;
    int i;
    fillarray:
    for(i = 0; i < service_ids.length; i++)
    {
      running = database.busDatabase.find_id("running", "roster", "weekStart", toDate, "service_id", service_ids[i]);
      thisService = database.busDatabase.find_id("time", "timetable_line", "service", service_ids[i], "timing_point", bus_stop);
      if(thisService > timing_point && thisService != 0)
      {
        if(enough > 4)
          break fillarray;

        int hours = 0;
        while (thisService >= 60)
        {
          thisService -= 60;
          hours++;
          if(hours >= 24)
            hours = 0;
        }
        if(thisService < 10)
          time = "" + hours + ":" + "0" + thisService;
        else
          time = "" + hours + ":" + thisService;
        
        if(running == 0)
          times[enough] = "" + (enough + 1) + ". "+ time + " (Sorry, this service has been canceled due to a monkey contaminating the path with banana skins. We appologise for any inconvinience caused.)";
        else
          times[enough] = "" + (enough + 1) + ". "+ time;
        enough++;
      }
    }
    }
    return times;
  }

  public boolean rosterExists(Date toDate)
  {
    if (startDate.getTime() == null) throw new InvalidQueryException("Nonexistent route");
    rosterIDs =  database.busDatabase.select_ids("service_id", "roster", "weekStart",toDate, "service_id");
    if(rosterIDs.length > 0)
      return true;
    else
    {
      RosterManager test = new RosterManager(startDate);
      test.createRoster();
      if(rosterIDs.length > 0)
        return true;
    }
    return false;
  }

  public String[] getAverage()
  {
    String[] timeArray = new String[5];
    int[] preTimes = new int[5];
    int[] nextTimes = new int[5];
    int[] run = new int[5];
    int gap = 0;
    int pre = BusStopInfo.getPreviousStop(bus_stop, route_id);
    int next = BusStopInfo.getNextStop(bus_stop, route_id);
    while(service_ids.length == 0)
    {
      pre = BusStopInfo.getPreviousStop(bus_stop, route_id);
      service_ids = database.busDatabase.select_ids("service", "timetable_line", "timing_point", pre, "daily_timetable", daily_timetable_id, "service");
      gap++;
    }
    int enough = 0;
    int i;
    fillarray:
    for(i = 0; i < service_ids.length; i++)
    {
      thisService = database.busDatabase.find_id("time", "timetable_line", "service", service_ids[i], "timing_point", pre);
      if(thisService > timing_point && thisService != 0)
      {
        if(enough > 4)
          break fillarray;
        else
        {
          run[enough] = database.busDatabase.find_id("running", "roster", "weekStart", toDate, "service_id", service_ids[i]);
          preTimes[enough] = database.busDatabase.find_id("time", "timetable_line", "service", service_ids[i], "timing_point", pre);
          enough++;
        }
      }
    }
    service_ids = database.busDatabase.select_ids("service", "timetable_line", "timing_point", bus_stop, "daily_timetable", daily_timetable_id, "service");
    while(service_ids.length == 0)
    {
      next = BusStopInfo.getNextStop(bus_stop, route_id);
      service_ids = database.busDatabase.select_ids("service", "timetable_line", "timing_point", next, "daily_timetable", daily_timetable_id, "service");
      gap++;
    }
    enough = 0;
    fillarray:
    for(i = 0; i < service_ids.length; i++)
    {
      thisService = database.busDatabase.find_id("time", "timetable_line", "service", service_ids[i], "timing_point", next);
      if(thisService > timing_point && thisService != 0)
      {
        if(enough > 4)
          break fillarray;
        else
        {
         if(run[enough] == 1)
           run[enough] = database.busDatabase.find_id("running", "roster", "weekStart", toDate, "service_id", service_ids[i]);
         nextTimes[enough] = database.busDatabase.find_id("time", "timetable_line", "service", service_ids[i], "timing_point", next);
         enough++;
        }
      }
    }
    System.out.println(pre + " " + next);

    for(i = 0; i < 5; i++)
    {
      //System.out.println(preTimes[i]);
      thisService = nextTimes[i] - preTimes[i];
      thisService = preTimes[i] + (thisService/2);
      int hours = 0;
      while (thisService >= 60)
      {
        thisService -= 60;
        hours++;
        if(hours >= 24)
          hours = 0;
      }
      if(thisService < 10)
        time = "" + hours + ":" + "0" + thisService;
      else
        time = "" + hours + ":" + thisService;

      if(run[i] == 0)
        timeArray[i] = "" + (i + 1) + ". "+ time + " (Sorry, this service has been canceled due to a monkey contaminating the path with banana skins. We appologise for any inconvinience caused.)";
      else
        timeArray[i] = "" + (i + 1) + ". "+ time;
    }
  return timeArray;
  }
}
