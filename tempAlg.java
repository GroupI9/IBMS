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
    for(int i = 0; i < 7; i++)
    {
      System.out.println(tempCal.getTime());
      thisday = tempCal.getTime();//convert cal to date obj
      today.todaytime = TimetableInfo.timetableKind(thisday);
      tempCal.add(Calendar.DATE, 1);
      serviceIDs = TimetableInfo.getServices(routeIDs[1], today.todaytime);
      toString(serviceIDs);
    }
            
  }
  
  public static void toString(int[]array)
  {
    for(int i = 0; i < array.length; i++)
      System.out.println(array[i]);
  }  
}
