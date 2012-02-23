import java.util.Date;

public class HolidayManager
{

  //stores the hardlimit to the number of holidays a driver can take
  private static int HOLIDAY_LIMIT = 25;
  private static int driverid;
  private static Date start;
  private static Date end;
  private static int daysRequested = 0;
  
  
  public static boolean requestHoliday(int driver_id, Date start_date, Date end_date)
  {
    driverid = driver_id;
    start = start_date;
    end = end_date;
    if(hasEnoughHolidays())
    {
      Date tempDate = start;
      for(i = 0;i < daysRequested; i++)
      {
        if(dayIsClear(tempDate))
          return false;
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
    int holidaysTaken = DriverInfo.getHolidaysTaken(driver_id);
      //if the sum of taken and requested exceeds the limit fail
    Date calDate = startDate;
    while(calDate.before(endDate)
    {
      calDate.add(Calendar.DAY_OF_MONTH, 1);
      daysRequested++;
    
    }
    return (holidaysTaken + daysRequested) < HOLIDAY_LIMIT
  
  }//hasEnoughHolidays
   
   //this method checks to see if a requested day has in excess of 10 drivers
   //on holiday.
  private static boolean dayIsClear(Date givenDay)
  {
    int numberTaken;
    int driverIDs[] = DriverInfo.getDrivers();
    database.openBusDatabase();
      for(i = 0; i < driverIDs.length(); i++)
      {
       if(!DriverInfo.isAvailable(i, givenDay))
         numberTaken++;
      }
    return numberTaken > 10;
  
  }
   
}
