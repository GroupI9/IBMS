/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.models;

import ibms.wrappers.TimetableInfo;
import java.util.ArrayList;

/**
 *
 * @author nunnerp0
 */
public class Service {
    public int id;
    public int routeId;
    public ArrayList<Integer> times = new ArrayList<Integer>();

    public Service(int id, int routeId){
        this.id = id;
        this.routeId = routeId;
        int serviceTimes[] = TimetableInfo.getServiceTimes(routeId, TimetableInfo.timetableKind.weekday, id);
        for(int time : serviceTimes){
            times.add(time);
        }
    }
    @Override
    public String toString(){
        return String.format("Service Id: %d.\nHas times: %s.", this.id, this.times);
    }
}
