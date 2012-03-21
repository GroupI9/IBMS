/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.models;

import ibms.wrappers.BusInfo;
import java.util.Date;

/**
 * This is an object to model the operations and data associated with busses
 * @author nunnerp0
 */
public class Bus {
    private String number;
    private int id;

    /**
     * A bus can be instanciated using its fleet number
     * @param fleetNumber is a 5 digit bus identifier
     */
    public Bus(String fleetNumber){
        this.id = BusInfo.findBus(fleetNumber);
        this.number = fleetNumber;
    }
    /**
     * A bus can also be instanciated using its driverId
     * @param driverId
     */
    public Bus(int busId){
        this.number = BusInfo.busNumber(busId);
        this.id = busId;

    }
    /**
     * Returns the state of the bus's availability for today
     * @return boolean status of aviliablity
     */
    public boolean isAvailable(){
        return BusInfo.isAvailable(this.id);
    }

    /**
     * returns the status of the bus's availability for the given date
     * @param requestedDate date you wish to check the buses aviliablity for
     * @return the availability t or f
     */
    public boolean isAvailable(Date requestedDate){
        return BusInfo.isAvailable(id, requestedDate);
    }

    /**
     * set the avilability of the bus on a requested date to true
     * @param requestedDate
     */
    public void setAvailable(Date requestedDate){
        BusInfo.setAvailable(this.id, requestedDate, true);
    }
    /**
     * Set the bus as available for the current date
     */
    public void setAvailable(){
        BusInfo.setAvailable(this.id, true);
    }

    /**
     * set the bus as unavailable for the given date
     * @param requestedDate
     */
    public void setUnavailable(Date requestedDate){
        BusInfo.setAvailable(id, requestedDate, false);
    }
    /**
     * set the bus as unavailable for today
     */
    public void setUnavailable(){
        BusInfo.setAvailable(id, false);
    }

    public String toString(){
        return String.format("Bus Number: %s, Bus Id: %d.\n", this.number, this.id);
    }
}
