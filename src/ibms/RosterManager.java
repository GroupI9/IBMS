package ibms;
import ibms.wrappers.*;
import java.util.*;

class Pack
{
  service serv;
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
  private service dailyservices[];
  private int todayservicetimes[];
  private int servicearrayindex = 0;
  private driverUsed[] driversUsed;
  private int driversUsedIndex = 0;
  private busUsed[] busesUsed;
  private int busesUsedIndex = 0;
  private service[] todayServices;
  
  public RosterManager(Calendar startDay)
  {
    database.openBusDatabase();
    startDate = (Calendar) startDay.clone();
    int getday = 0;
    if(startDate.get(Calendar.DAY_OF_WEEK) != 2)
    {
      getday = startDate.get(Calendar.DAY_OF_WEEK);
      if(getday == 1)
        getday = 6;
      else
	getday = (getday - 2); 
      startDate.add(Calendar.DATE, -getday);
    }  
    
    endDate = (Calendar)startDate.clone();
    endDate.add(Calendar.DATE, 6);   
    
    numberOfDays = 7; 
    packs = new Pack[numberOfDays][];   
    buses = BusInfo.getBuses();
    drivers = DriverInfo.getDrivers();
    minutesWorked = new int[drivers.length];
    numberOfServices = 0;
    routes = BusStopInfo.getRoutes();   
    driversUsed = new driverUsed[drivers.length]; 
    busesUsed = new busUsed[buses.length]; 

  }


  public void createRoster()
  {
    Calendar today = (Calendar) startDate.clone();
    int count;   
    for(int i=0; i<numberOfDays; i++)
    {
      count = 0;      
      numberOfServices = getNumberOfServices(today.getTime()); 
      todayServices = getServices(today);				// correct it!
      packs[i] = new Pack[numberOfServices];
      for(int j=0; j<numberOfServices; i++)
      {
        System.out.println("" + i + " " + j);
        packs[i][j].serv = getNextService();		// correct it!
	packs[i][j].driver_id = getLeastWorkingDriver(drivers, today.getTime(), packs[i][j].serv);   // correct it!
        packs[i][j].bus_id = getAvailableBus(buses, today.getTime(), packs[i][j].serv);				// correct it!
//        setDriverUnavailable(packs[i][j].driver_id);
//	setBusUnavailable(packs[i][j].bus_id);        
        minutesWorked[packs[i][j].driver_id] += (packs[i][j].serv.endtime) - (packs[i][j].serv.starttime);
      }	    
      today.add(Calendar.DAY_OF_MONTH, 1);
    }    
  }


  private int getNumberOfServices(Date day)
  {
    int numberOfServicesToday = 0;
    for(int j=0; j<routes.length; j++)
      numberOfServicesToday += TimetableInfo.getNumberOfServices(routes[j], day); // have to be corrected for 358
    return numberOfServicesToday;
  }



  private service[] getServices(Calendar day)
  {    
    dailyservices = new service[numberOfServices];
    for(int j = 0; j < routes.length; j++)//for each route
    {
      services = TimetableInfo.getServices(routes[j],
					 TimetableInfo.timetableKind(day.getTime()));
      int num = TimetableInfo.getNumberOfServices(routes[j],
					TimetableInfo.timetableKind(day.getTime()));
      for(int k = 0; k < num; k++)//for each service
      {
        todayservicetimes = TimetableInfo.getServiceTimes(routes[j],
	 				 TimetableInfo.timetableKind(day.getTime()),k);
	service thisservice = new service(services[k], todayservicetimes[0], 
	  				todayservicetimes[todayservicetimes.length
					- 1]);
	dailyservices[servicearrayindex] = thisservice;
        servicearrayindex++;
      }
    }
    return dailyservices;   
  }


  private service getNextService()
  {
    int startTime = 1500;
    int index=0;
    for(int i=0; i<todayServices.length; i++)
    {
      if(todayServices[i].starttime < startTime && !todayServices[i].used)
      {
        index = i;
	startTime = todayServices[i].starttime;
      }
    }
    todayServices[index].used = true;

    return todayServices[index];
  }

  private int getLeastWorkingDriver(int[] driversList, Date day, service serv)
  {
    int minMins = 3000;
    int driver_id=0;
    boolean temp = false;
    for(int i=0; i<driversList.length; i++)
    {
      if(minutesWorked[i] < minMins && DriverInfo.isAvailable(driversList[i], day))
      {        
        for(int j=0; j<driversUsedIndex; j++)
	{	  
          if(driversList[i] == driversUsed[j].driver_id)
	  {
            if(serv.starttime > driversUsed[j].endTime)
	      temp = true;
	    else
	      temp = false;	    
	  }  	  
	}   
	if(temp)
	{
	  driver_id = driversList[i];
          minMins = minutesWorked[i];
	  driversUsed[driversUsedIndex] = new driverUsed(driver_id, serv.starttime, serv.endtime);
	  driversUsedIndex++;
	}    
      }      
    }  
      
    return driver_id;
  }

  private int getAvailableBus(int[] busesList, Date day, service serv)
  {
    int bus_id = 0;
    boolean temp = false;
    for(int i=0; i<buses.length; i++)
    {
      if(BusInfo.isAvailable(busesList[i], day))
      {
        for(int j=0; j<busesUsedIndex; j++)
        {
	  if(busesList[i] == busesUsed[j].bus_id)
	  {
	    if(serv.starttime > busesUsed[j].endTime)
	      temp = true;
	    else
	      temp = false;
	  }
        }
	if(temp)
	{
	  bus_id = busesList[i];
	  busesUsed[busesUsedIndex] = new busUsed(bus_id, serv.starttime, serv.endtime);
	  busesUsedIndex++;
	}
      }
    }
    return bus_id;
  }
/*
  private void setDriverUnavailable(int driver_id)
  {
  }
 
  private void setBusUnavailable(int bus_id)
  {
  }

  private void setDriverAvailable(int driver_id)
  {
  }

  private void setBusAvailable(int bus_id)
  {
  }  
*/ 
}
