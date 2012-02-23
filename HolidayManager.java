//made an edit
public class HolidayManager{

   //stores the hardlimit to the number of holidays a driver can take
   private static int HOLIDAY_LIMIT = 25;
   
   
   public static void requestHoliday(int driver_id, Date start, Date end){
     
   
   }

   //method determines in the driver has enough available holidays for their request
   private static boolean hasEnoughHolidays(int driver_id, Date startDate, Date endDate)
   {
      //connect to the database and retried the specified drivers details.
      database.openBusDatabase();
      
      //get holidays taken.
      int holidaysTaken = DriverInfo.getHolidaysTaken(driver_id);
      
      //if the sum of taken and requested exceeds the limit fail
      return (holidaysTaken + daysRequested) < HOLIDAY_LIMIT
        

      
   }//hasEnoughHolidays
   
   //this method checks to see if a requested day has in excess of 10 drivers on holiday.
   
   private static boolean dayIsClear(Date day){
   
   }
}
