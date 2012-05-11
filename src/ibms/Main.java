package ibms;
import ibms.wrappers.*;
import ibms.gui.DriverToolsGUI;
import ibms.gui.*;
import ibms.gui.StartGUI;
import java.util.Calendar;

public class Main{
    public static void main(String[] args)
    {
        //DriverToolsGUI driver = new DriverToolsGUI();
        //StartGUI gui = new StartGUI();
        //gui.setVisible(true);

        database.openBusDatabase();
        LauncherGUI gui = new LauncherGUI();
        gui.setVisible(true);
        

        //Calendar startDate = Calendar.getInstance();
	//startDate.set(2012, 0, 25);
        //RosterManager test = new RosterManager(startDate);
	//test.createRoster();
        //myGetRosterGUI rosterGui = new myGetRosterGUI();
        //rosterGui.setVisible(true);
    }
}