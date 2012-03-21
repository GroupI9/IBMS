/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms.models;

import ibms.wrappers.BusStopInfo;
import ibms.wrappers.TimetableInfo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nunnerp0
 */

public class Route {
    private String name;
    private int id;
    private ArrayList<BusStop> busStops = new ArrayList<BusStop>();
 

    public Route(int routeId){
        this.id = routeId;
        this.name = BusStopInfo.getRouteName(routeId);
        int stops[] = BusStopInfo.getBusStops(routeId);


     
        //get all the stops on the route
        for(int stop : stops)
            busStops.add(new BusStop(stop));
    }

    /**
     * Returns the number of services on the route today.
     * @return
     */
    public int numberOfServices(){
        return TimetableInfo.getNumberOfServices(id);
    }

}
