import java.util.*;

public class LoginManager
{
  private final int driverID;
  boolean found = false;
  public LoginManager(int givernDriverId)
  {
    driverID=givernDriverId; 
    idValid(driverID); 
  } 
  public void idValid(int driverID)
  { 
    database.openBusDatabase();
    int driverIDs[] = DriverInfo.getDrivers();
    for(int i = 0; i < driverIDs.length; i++)
    {
      if(driverIDs[i] == driverID)
      {
	found = true;
	break;
      }
      else
      {
        found = false;
      }
    }
    if(found==true)
    {
      System.out.println("Driver " + driverID +  " found");
    }
    else
    {
      System.out.println("Driver " + driverID +  " not found");   
    }
  }
  /*
  public static void main(String[] args)
  {
    LoginManager c = new LoginManager(2012);
  }
 */ 
}
