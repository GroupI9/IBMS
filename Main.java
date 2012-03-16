import java.util.Date;


/*
 * A very simple application illustrating how to use the interface.
 * Prints the names of all the drivers in the database.
 * The ahae bae
 * Paul - Testing
 * @author John Sargeant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LoginGui login = new LoginGui();
	login.setVisible(true);
        database.openBusDatabase();
        int[] driverIDs = DriverInfo.getDrivers();
        String[] driverNames = new String [driverIDs.length];
        //for (int i=0; i<driverIDs.length; i++)
            //System.out.println(DriverInfo.getName(driverIDs[i]));

       // RequestHolidayGUI RHGui = new RequestHolidayGUI();
       // RHGui.setVisible(true); 

        /*Date s = new Date(112, 1, 14);
        Date e = new Date(112, 1, 18);
        System.out.println(s.toString());
 

        boolean test = HolidayManager.requestHoliday(driverIDs[0], s, e);  
        if(test)
         System.out.println("Wohooo!");*/
        
    }

}
