import java.util.*;

public class Holiday{
    //store the start and end date of the requested holiday
    private Calendar startDate;
    private Calendar endDate;
    private final int HOLIDAY_LIMIT = 25;
    //store the id for the driver requesting the holiday
    int driverId;
   
    //instanciate the object
    public Holiday(int p_driverId, Calendar p_startDate, Calendar p_endDate){
        //instanciate the class with the variables provided
        this.driverId = p_driverId;
        this.startDate = p_startDate;
        this.endDate = p_endDate;
	Calendar acceptDates = startDate;
        if(hasEnoughDays() && allDaysAreClear()){

            System.out.println("This holiday can be set.");
            for(int i = 1; i < length(); i++){
                //for each day set the driver unavilable
                DriverInfo.setAvailable(driverId, acceptDates.getTime(), true);
                acceptDates.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
    }
    
    //returns the length in days of this holiday request
    public int length(){
        return (int)( (endDate.getTime().getTime() - startDate.getTime().getTime())/(1000 * 60 * 60 * 24));
    }

    private boolean hasEnoughDays(){
        int currentCount = DriverInfo.getHolidaysTaken(driverId);
        return (currentCount + this.length()) < HOLIDAY_LIMIT;
    }
    private boolean allDaysAreClear(){
      Calendar tempDate = startDate;
      for(int i = 0;i < length(); i++)
      {
        if(dayIsClear(tempDate))
          return false;
        tempDate.add(Calendar.DAY_OF_MONTH, 1);
      }
      return true;
    }
    private boolean dayIsClear(Calendar givenDay)  {
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
