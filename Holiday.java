import java.util.*;

public class Holiday{
    //this is my holiday class
    //store the start and end date of the requested holiday
    private Calendar startDate;
    private Calendar endDate;
    private final int HOLIDAY_LIMIT = 25;
    //store the id for the driver requesting the holiday
    int driverId;
    public int numberTaken;
    public static int message;
   
    //instanciate the object
    public Holiday(int p_driverId, Calendar p_startDate, Calendar p_endDate){
        //instanciate the class with the variables provided
        this.driverId = p_driverId;
        this.startDate = p_startDate;
        this.endDate = p_endDate;
	Calendar acceptDates = (Calendar) startDate.clone();
        if(hasEnoughDays() && allDaysAreClear()){                        
            for(int i = 1; i <= length(); i++){                
                //for each day set the driver unavilable                
                DriverInfo.setAvailable(driverId, acceptDates.getTime(), false);                	  
                acceptDates.add(Calendar.DAY_OF_MONTH, 1);
            }	                     
            message = 1;
        }
        else
          message = 0;
        //database.close();
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
      Calendar tempDate = (Calendar) startDate.clone();
      for(int i = 0;i < length(); i++)
      {
        if(!dayIsClear(tempDate))
          return false;
        tempDate.add(Calendar.DAY_OF_MONTH, 1);
      }
      return true;
    }
    
    private boolean dayIsClear(Calendar givenDay)  {
      numberTaken=0;
      int driverIDs[] = DriverInfo.getDrivers();
      database.openBusDatabase();
      for(int i = 0; i < driverIDs.length; i++)
      {
        if(!DriverInfo.isAvailable(driverIDs[i], givenDay.getTime()))
          numberTaken++;
      }      
      return numberTaken < 10;  
    }
}
