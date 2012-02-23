import java.util.Date;
import java.util.Calendar;

public class HolidayManager
{

  //stores the hardlimit to the number of holidays a driver can take
  private static int HOLIDAY_LIMIT = 25;
  private static int driverid;
  private static Calendar start;
  private static Calendar end;
  private static int daysRequested = 0;
  
  
  public static boolean requestHoliday(int driver_id, Date start_date, Date end_date)
  {
    driverid = driver_id;
    start.setTime(start_date);
    end.setTime(end_date);
    if(hasEnoughHolidays())
    {
      Calendar tempDate = start;
      for(int i = 0;i < daysRequested; i++)
      {
        if(dayIsClear(tempDate))
          return false;
	//int buf_day = tempDate.getDay();
 	tempDate = start;
        tempDate.add(Calendar.DAY_OF_MONTH, 1);
      }
    }
    else
      return false;
    return true;
  }
  //method determines in the driver has enough available holidays for their request
  private static boolean hasEnoughHolidays()
  {
      //connect to the database and retried the specified drivers details.
    database.openBusDatabase();
      //get holidays taken.
    int holidaysTaken = DriverInfo.getHolidaysTaken(driverid);
      //if the sum of taken and requested exceeds the limit fail
    Calendar calDate = start;
    while(calDate.before(end))
    {
      //int buf_day = calDate.getDay();
      calDate = start;
      calDate.add(Calendar.DAY_OF_MONTH, 1);
      daysRequested++;
    
    }
    return (holidaysTaken + daysRequested) < HOLIDAY_LIMIT;
  
  }//hasEnoughHolidays
   
   //this method checks to see if a requested day has in excess of 10 drivers
   //on holiday.
  private static boolean dayIsClear(Calendar givenDay)
  {
    int numberTaken=0;
    int driverIDs[] = DriverInfo.getDrivers();
    database.openBusDatabase();
      for(int i = 0; i < driverIDs.length; i++)
      {
       if(!DriverInfo.isAvailable(i, givenDay.getTime()))
         numberTaken++;
      }
    return numberTaken > 10;
  
  }
   
}
