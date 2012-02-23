
public class HolidayManager{

   //stores the hardlimit to the number of holidays a driver can take
   private static int HOLIDAY_LIMIT = 25;
   
   
   public static void requestHoliday(int driver_id, Date start, Date end){
   
   }
   //when given a driver id this method check if the driver has enough holidays
   //for their request to be allowed.
   private static boolean hasEnoughHolidays(int driver_id, int daysRequested){
      //connect to the database and retried the specified drivers details.
      database.openBusDatabase();
      
      //get holidays taken.
      int holidaysTaken = DriverInfo.getHolidaysTaken(driver_id);
      
      if(holidaysTaken + daysRequested > HOLIDAY_LIMIT)
         return false;
      else
         return true;

      
   }//hasEnoughHolidays
}
