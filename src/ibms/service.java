package ibms;

public class service
{
  public int serviceid;
  public int starttime;
  public int endtime;
  public boolean used;
  
  
  public service(int id, int start, int end) 
  {
    serviceid = id;
    starttime = start;
    endtime = end;
    used = false;    
  }

  public service() 
  {
  
  }
}
