import java.util.*;
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
    TimetableInfo today = new TimetableInfo();//get timetablekind

    Calendar tempCal = (Calendar)startDate.clone();
    for(int i = 0; i < 7; i++)//for each day
    {
      thisday = tempCal.getTime();//convert cal to date obj
      today.todaytime = TimetableInfo.timetableKind(thisday);//get timetablekind
      System.out.println(tempCal.getTime());
      for(int j = 0; j < routeIDs.length; j++)//for each route
      {
	System.out.println("Route: " + routeIDs[j]);
	serviceIDs = TimetableInfo.getServices(routeIDs[j], today.todaytime);	
	for(int k = 0; k < serviceIDs.length; k++)//for each service
	{
	  System.out.println("Service: " + serviceIDs[k]);
	  todayservicetimes = TimetableInfo.getServiceTimes(routeIDs[j], today.todaytime, serviceIDs[k]);
	  toString(todayservicetimes);  
	}
      }
      tempCal.add(Calendar.DATE, 1);
    }
    //  todayservicetimes = TimetableInfo.getServiceTimes(routeIDs[1], today.todaytime,
   //   serviceIDs[1]);
   //   toString(todayservicetimes);    
  }
  
  public static void toString(int[]array)
  {
    for(int i = 0; i < array.length; i++)
      System.out.println(array[i]);
  }  
}
