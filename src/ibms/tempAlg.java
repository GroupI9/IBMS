package ibms;

import java.util.*;
import ibms.*;
import ibms.wrappers.*;
import static java.util.Calendar.*;

public class tempAlg
{
  private Calendar startDate;
  private Calendar endDate;
  private int driverIDs[];
  private int busIDs[];
  private int routeIDs[];
  private int serviceIDs[];
  private int busToRoute[][];
  private int todayservicetimes[];
  private int numberofservices = 0;
  private service dailyservices[];
  private int servicearrayindex = 0;
  
  public tempAlg(Calendar sDate)
  {
    database.openBusDatabase();
    startDate = sDate;
    endDate = (Calendar)startDate.clone();
    endDate.add(Calendar.DATE, 6);
    routeIDs = BusStopInfo.getRoutes();//get all routes
    driverIDs = DriverInfo.getDrivers();//get all drivers
    busIDs = BusInfo.getBuses();//get all buses
    
    Date thisday;//convert cal to date obj
    Calendar tempCal = (Calendar)startDate.clone();
   // for(int i = 0; i < 7; i++)//for each day
   // {
      thisday = tempCal.getTime();//convert cal to date obj
      for(int j = 0; j < routeIDs.length; j++)
      {
        numberofservices += TimetableInfo.getNumberOfServices(routeIDs[j], 
					TimetableInfo.timetableKind(thisday));
      }
      dailyservices = new service[numberofservices];
      for(int j = 0; j < routeIDs.length; j++)//for each route
      {
	serviceIDs = TimetableInfo.getServices(routeIDs[j],
					 TimetableInfo.timetableKind(thisday));
	todayservicetimes = TimetableInfo.getTimingPoints(routeIDs[j]);
	int num = TimetableInfo.getNumberOfServices(routeIDs[j],
					TimetableInfo.timetableKind(thisday));
	numberofservices += serviceIDs.length;
	for(int k = 0; k < num; k++)//for each service
	{
	  todayservicetimes = TimetableInfo.getServiceTimes(routeIDs[j],
	 				 TimetableInfo.timetableKind(thisday),k);
	  service thisservice = new service(serviceIDs[k], todayservicetimes[0], 
	  				todayservicetimes[todayservicetimes.length
					- 1]);
	  dailyservices[servicearrayindex] = thisservice;
	  servicearrayindex++;
	}
      }
      tempCal.add(Calendar.DATE, 1);
      numberofservices = 0;
      toString(dailyservices);
    //}
  }
  
  public static void toString(service[]array)
  {
    for(int i = 0; i < array.length; i++)
      System.out.println(array[i].serviceid + " " + array[i].starttime + " " +
      array[i].endtime);
  }
  
  public static void sortServices(int[]array)
  {
 
  }  
}
