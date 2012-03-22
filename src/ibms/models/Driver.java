/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.models;


import ibms.exceptions.UnknownDriverException;
import ibms.wrappers.*;
import java.util.Date;

public class Driver {
    private String name;
    private int driverId;
    private String number;
    private int hoursThisWeek;
    private int hoursThisYear;
    private final int HOLIDAY_LIMIT = 25;

    /**
     * The method can be instanciated with a single driver id. This will
     * get the driver information from the database and fill the instance
     * variables with the relevant information.
     * @param driverId the driver number for the driver you wish to retrieve
     */
    public Driver(int driverId) throws UnknownDriverException{
        //using the helper method retrieve the drivers info
        database.openBusDatabase();
        this.driverId = driverId;
        if((this.name = DriverInfo.getName(driverId)).length() > 0 ){
            this.number = DriverInfo.getNumber(driverId);
        }else{
            throw new UnknownDriverException("Couldn't find a driver with that id.");
        }

    }
    public Driver(String driverNumber) throws UnknownDriverException{
        database.openBusDatabase();
        this.driverId = DriverInfo.findDriver(driverNumber);
        if((this.name = DriverInfo.getName(driverId)).length() > 0){
            this.number = driverNumber;

        }else
            throw new UnknownDriverException("Couldn't find that driver");
    }
    
    public int getHolidaysTaken(){
        return DriverInfo.getHolidaysTaken(driverId);
    }
    public int holidaysAvailable(){
        return HOLIDAY_LIMIT - getHolidaysTaken();
    }
    public int getNumber(){
        return this.driverId;
    }
    public String getName(){
        return this.name;

    }
    /**
     * This method will check the current instance of the driver's database entry
     * to see if the driver is available of the given date
     * @param requestedDate is a java date object for the day you wish to check
     * @return true or false
     */
    public boolean available(Date requestedDate){
        return DriverInfo.isAvailable(this.driverId,requestedDate);
    }

    /**
     * This method will check if the driver is available today. If the driver is
     * it will return true, if not false.
     * @return
     */
    public boolean available(){
        return DriverInfo.isAvailable(this.driverId);
    }

    /**
     * try to set the driver avilable for today
     */
    public void setAvailable(){
        DriverInfo.setAvailable(this.driverId, true);
    }
    /**
     * Set the driver unavilable for today
     */
    public void setUnavilable(){
        DriverInfo.setAvailable(this.driverId, false);
    }
    /**
     * Set the driver avilable for the date given
     * @param requestDate the date you wish to set availablity for
     */
    public void setAvailable(Date requestDate){
        DriverInfo.setAvailable(this.driverId, requestDate,true);
    }
    /**
     * Set the driver unaviliable for a given date
     * @param requestDate the day you wish to set the driver unavailable for
     */
    public void setUnavilable(Date requestDate){
        DriverInfo.setAvailable(this.driverId, requestDate, false);
    }
    /**
     * When the program is referenced as a string it will produce a simple print out of the objects data
     * @return
     */
    public String toString(){
        return String.format("Driver Number: %d.\nDriver Name: %s\n"
                + "Holidays Taken: %d\nHours This Week: %d",
                this.driverId, this.name, this.getHolidaysTaken(), this.hoursThisWeek);
    }
}
