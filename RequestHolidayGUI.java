import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class RequestHolidayGUI extends JFrame implements ActionListener
{
  private final JTextField driverId = new JTextField(10);
  private final JTextField daysNumber = new JTextField(10);
  private final JTextField message = new JTextField(20);

  private final JTextField sDay = new JTextField(10);
  private final JTextField sMonth = new JTextField(10);
  private final JTextField sYear = new JTextField(10);

  private final JTextField eDay = new JTextField(10);
  private final JTextField eMonth = new JTextField(10);
  private final JTextField eYear = new JTextField(10);
  
  public RequestHolidayGUI()
  {
    setTitle("Request holiday");
    Container contents = getContentPane();
    contents.setLayout(new GridLayout(0,1));


    contents.add(new JLabel("Driver ID:"));
    contents.add(driverId);
    //contents.add(new JLabel("Number of days:"));
    //contents.add(daysNumber);
    contents.add(new JLabel("Start day:"));
    contents.add(sDay);    
    contents.add(new JLabel("Start month:"));
    contents.add(sMonth);    
    contents.add(new JLabel("Start year:"));
    contents.add(sYear);  

    contents.add(new JLabel("End day:"));
    contents.add(eDay);    
    contents.add(new JLabel("End month:"));
    contents.add(eMonth);    
    contents.add(new JLabel("End year:"));
    contents.add(eYear);      


    JButton computeJButton = new JButton("Check");
    contents.add(computeJButton);
    computeJButton.addActionListener(this);

    contents.add(new JLabel("Message:"));
    contents.add(message);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }

  public void actionPerformed(ActionEvent event)
  {
    int id = Integer.parseInt(driverId.getText());
    //int number = Integer.parseInt(daysNumber.getText());
    //HolidayManager.RequestHoliday(id, number);

    int sday = Integer.parseInt(sDay.getText());
    int smonth = Integer.parseInt(sMonth.getText());
    int syear = Integer.parseInt(sYear.getText());
    int eday = Integer.parseInt(sDay.getText());
    int emonth = Integer.parseInt(sMonth.getText());
    int eyear = Integer.parseInt(sYear.getText());

    Calendar startDate = new GregorianCalendar(syear, smonth, sday);
    Calendar endDate = new GregorianCalendar(eyear, emonth, eday);

    Holiday get_hol = new Holiday(id, startDate, endDate);
    message.setText("Wohoo!");    
  }  

  /*public static void main(String[] args)
  {
    RequestHolidayGUI RHGui = new RequestHolidayGUI();
    RHGui.setVisible(true);
  }*/
}
