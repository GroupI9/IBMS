package ibms;

import ibms.gui.DriverToolsGUI;
import ibms.gui.StartGUI;
import java.util.Calendar;

public class Main{
    public static void main(String[] args)
    {
        //DriverToolsGUI driver = new DriverToolsGUI();
       // StartGUI gui = new StartGUI();
       // gui.setVisible(true);

        Calendar startDate = Calendar.getInstance();
	startDate.set(2012, 0, 25);
        RosterManager test = new RosterManager(startDate);
	test.createRoster();
    }
}