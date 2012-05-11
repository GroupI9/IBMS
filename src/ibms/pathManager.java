/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ibms;
import ibms.wrappers.*;
import ibms.models.*;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.*;


/**
 *
 * @author malikze0
 */

class Vertex implements Comparable<Vertex>
{
    public String name;
    public int id;
    public int outdegree;
    public boolean visited;
    //public Edge[] adjacencies;
    public List<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    /*public Vertex(String argName)
    {
        name = argName;
    }*/
    public void set(String Name, int Id)
    {
        name = Name;
        id = Id;
        outdegree = 0;
        visited = false;
        //adjacencies = new ArrayList<Edge>();
    }

    public int getId()
    {
        return id;
    }
    @Override
    public String toString()
    {
        return name;
    }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge
{    
    public Vertex target;
    public double weight;
    public Edge(Vertex argTarget, double argWeight)
    {
        target = argTarget;
        weight = argWeight;
    }    
}



public class pathManager {

    private Vertex[] vertices;    
    private int MaxSize;
    private List<Vertex> previousRoute;
    private int numberOfChanges;
    private void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
	vertexQueue.add(source);

	while (!vertexQueue.isEmpty()) {
	    Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		if (distanceThroughU < v.minDistance) {
		    vertexQueue.remove(v);

		    v.minDistance = distanceThroughU ;
		    v.previous = u;
		    vertexQueue.add(v);
		}
            }
        }
    }

    private List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public void Initialize()
    {
        try {
            FileInputStream fstream = new FileInputStream("graph.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            String str;
            String max = "MAX";
            String node = "NODE";
            
            int j = 0;
            int source;
            int target;
            int distance;
            while((strLine = br.readLine()) != null)
            {
                StringTokenizer tokens = new StringTokenizer(strLine);
                str = tokens.nextToken();

                if(max.equals(str))
                {
                    str = tokens.nextToken();
                    MaxSize = Integer.parseInt(str);
                    vertices = new Vertex[MaxSize];
                    
                    for(int i=0; i<MaxSize; i++)
                    {
                        vertices[i] = new Vertex();
                        vertices[i].adjacencies = new ArrayList<Edge>();
                    }
                }
                else
                {
                    if(node.equals(str))
                    {                        
                        str = tokens.nextToken();
                        int id = Integer.parseInt(str);
                        str = tokens.nextToken();
                        vertices[j].set(str, id);                        
                        j++;
                    }
                    else
                    {
                        str = tokens.nextToken();
                        source = Integer.parseInt(str);
                        str = tokens.nextToken();
                        target = Integer.parseInt(str);
                        str = tokens.nextToken();
                        distance = Integer.parseInt(str);
                        int sourceIdx = 0;
                        int targetIdx = 0;
                        for(int i=0; i<MaxSize; i++)
                        {
                            if(vertices[i].id == source)
                                sourceIdx = i;
                            if(vertices[i].id == target)
                                targetIdx = i;
                        }

                        vertices[sourceIdx].adjacencies.add(new Edge(vertices[targetIdx], distance));
                        //vertices[source].adjacencies[vertices[source].outdegree] = new Edge(vertices[target], distance);
                        vertices[sourceIdx].outdegree++;
                    }
                }
            }

        }
        catch(Exception e) {
            System.err.println("Error!: " + e);
        }
    }

    public String findPath(int sourceId, int targetId)
    {
        numberOfChanges = 0;
        String result = "";
        database.openBusDatabase();
        Initialize();
        int sourceIdx = 0;
        int targetIdx = 0;
        for(int i=0; i<MaxSize; i++)
        {
            if(vertices[i].getId() == sourceId)
              sourceIdx = i;

            if(vertices[i].id == targetId)
                targetIdx = i;
        }
        computePaths(vertices[sourceIdx]);       

        List<Vertex> path = getShortestPathTo(vertices[targetIdx]);
        result += "Path: " + path;
        this.previousRoute = path;
        

        int[] routes = BusStopInfo.getRoutes();
        int tempRouteId = 0;
        for(int routeId : routes)
        {
            for(int busStopId : BusStopInfo.getBusStops(routeId))
            {
                if(path.get(0).id == busStopId)
                {
                    tempRouteId = routeId;
                    result += "\nGet the bus: "+ BusStopInfo.getRouteName(routeId);
                    numberOfChanges += 1;
                }
            }
        }

        for(Vertex busStop : path)
        {
            for(int routeId : routes)
            {
                for(int busStopId : BusStopInfo.getBusStops(routeId))
                {
                    if(busStop.id == busStopId)
                        if(tempRouteId != routeId)
                        {
                            tempRouteId = routeId;
                            result += "\nChange bus to "+ BusStopInfo.getRouteName(routeId) + " at "+busStop.name;
                        }
                }
            }
        }
        return result;
    }
    
    public int previousSize(){
        return this.previousRoute.size();
    }
    public int getNumberOfChanges(){
        return this.numberOfChanges;
    }
    
   public int sizeOfGraph(){
       return this.vertices.length;
   }

}
