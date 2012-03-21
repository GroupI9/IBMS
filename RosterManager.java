import java.util.*;

class Pack
{
  int service_id;
  int bus_id;
  int driver_id;
}


public class RosterManager
{
  private int[] services;
  private int[] buses;
  private int[] drivers;
  private int[] minutesWorked;
  private int[] routes;
  private Pack[][] packs;
  private int numberOfServices;
  private int route;
  private Calendar startDate;
  private Calendar endDate;
  private int numberOfDays;

  public RosterManager(Calendar startDate, Calendar endDate)
  {
    this.startDate = startDate;
    this.endDate = endDate;
    numberOfDays = (endDate.getTime().getTime() - startDate.getTime().getTime())/(1000 * 60 * 60 * 24); 
    packs = new Pack[numberOfDays][];   
    buses = BusInfo.getBuses();
    drivers = DriverInfo.getDrivers();
    minutesWorked = new int[drivers.length];
    numberOfServices = 0;
    routes = BusStopInfo.getRoutes();
  }


  public void createRoster()
  {
    Calendar today = (Calendar) startDate.clone();
    int[] todayServices;
    for(int i=0; i<numberOfDays; i++)
    {
      int count = 0;      
      numberOfServices = getNumberOfServices(today); 
      todayServices = getServices(today);				// correct it!
      packs[i] = new Pack[numberOfServices];
      for(int j=0; j<numberOfServices; i++)
      {
        pack[i][j].service_id = getService()	;			// correct it!
	pack[i][j].driver_id = getLeastWorkingDriver(drivers, today);   // correct it!
        pack[i][j].bus_id = getAvailableBus();				// correct it!
        setDriverUnavailable(pack[i][j].driver_id);
	setBusUnavailable(pack[i][j].bus_id);        
      }	    
      today.add(Calendar.DAY_OF_MONTH, 1);
    }    
  }


  private int getNumberOfServices(Date day)
  {
    int numberOfServicesToday
    for(int j=0; j<routes.length; j++)
      numberOfServicesToday = TimetableInfo.getNumberOfServices(route, day); // have to be corrected for 358
    return numberOfServicesToday;
  }

  private int[] getServices(Calendar day)
  {
    int[] allServices;
    int[] Services;
    for(int i=0; i<routes.length; i++)
    {
      int[] Services = TimetableInfo.getServices(route, TimetableInfo.timetableKind(day));
      allServices = concat(Services, allServices);
    }
    return allServices;
  }


  private int[] concat(int[] A, int[] B) 
  {
    int[] C= new int[A.length+B.length];
    System.arraycopy(A, 0, C, 0, A.length);
    System.arraycopy(B, 0, C, A.length, B.length);
    return C;
  }


  private int[] getService()
  {
  }

  private int getLeastWorkingDriver(int[] driversList, Calendar day)
  {
    int minMins = 3000;
    int driver_id=0;
    for(int i=0; i<driversList.length; i++)
    {
      if(minutesWorked[i] < minMins && DriverInfo.isAvailable(driverList[i], day))
      {
        driver_id = i;
        minMins = minutesWorked[i];
      }      
    }
    return driver_id;
  }

  private int getAvailableBus()
  {
  }

  private void setDriverUnavailable(int driver_id)
  {
  }
 
  private void setBusUnavailable(bus_id)
  {
  }

  private void setDriverAvailable(int driver_id)
  {
  }

  private void setBusAvailable(int bus_id)
  {
  }   
}
