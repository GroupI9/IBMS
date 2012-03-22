package ibms.models;

import ibms.exceptions.NotEnoughHolidaysException;
import ibms.wrappers.database;
import ibms.wrappers.DriverInfo;
import java.util.*;

public class Holiday{
    //store the start and end date of the requested holiday
    private Calendar startDate;
    private Calendar endDate;
    private final int HOLIDAY_LIMIT = 25;
    //store the id for the driver requesting the holiday
    int driverId;
    public int numberTaken;
    public static int message;
   
    //instanciate the object
    public Holiday(int p_driverId, Calendar p_startDate, Calendar p_endDate) throws Exception{
        //instanciate the class with the variables provided
        this.driverId = p_driverId;
        this.startDate = p_startDate;
        this.endDate = p_endDate;
	Calendar acceptDates = (Calendar) startDate.clone();
        if(!this.hasEnoughDays())
            throw new NotEnoughHolidaysException();
       
        
        else {
            for(int i = 1; i <= length(); i++){
                if(this.dayIsClear(acceptDates)){
                    //for each day set the driver unavilable
                    DriverInfo.setAvailable(driverId, acceptDates.getTime(), false);
                    DriverInfo.setHolidaysTaken(driverId,DriverInfo.getHolidaysTaken(driverId) + 1);
                }
                acceptDates.add(Calendar.DAY_OF_MONTH, 1);

            }
        }

    }
    
    //returns the length in days of this holiday request
    public int length(){
        int daysBetween = 1;
        Calendar date = (Calendar) this.startDate.clone();
        while(date.before(endDate)){
            date.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    private boolean hasEnoughDays(){        
        int currentCount = DriverInfo.getHolidaysTaken(driverId);        
        return (currentCount + this.length()) <= HOLIDAY_LIMIT;
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
        return (DriverInfo.isAvailable(this.driverId, givenDay.getTime()));
    }
}
