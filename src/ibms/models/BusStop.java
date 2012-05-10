/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.models;

import ibms.wrappers.BusStopInfo;

/**
 *
 * @author nunnerp0
 */
public class BusStop {
    private String fullName;
    private int stopId;
    private boolean isTimingPoint;

    public BusStop(int stopId){
        this.fullName = BusStopInfo.getFullName(stopId);
        this.stopId = stopId;
        this.isTimingPoint = BusStopInfo.isTimingPoint(stopId);

    }
    
    public int getId(){
        return this.stopId;
    }
    public String toString(){
        return String.format("Stop: %s.\n", this.fullName);
    }
}
