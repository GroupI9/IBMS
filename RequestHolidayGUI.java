import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RequestHolidayGUI extends JFrame implements ActionListener
{
  private final JTextField driverId = new JTextField(10);
  private final JTextField daysNumber = new JTextField(10);
  private final JTextField message = new JTextField(20);
  
  public RequestHolidayGUI()
  {
    setTitle("Request holiday");
    Container contents = getContentPane();
    contents.setLayout(new GridLayout(0,2));


    contents.add(new JLabel("Driver ID:"));
    contents.add(driverId);
    contents.add(new JLabel("Number of days:"));
    contents.add(daysNumber);

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
    int number = Integer.parseInt(daysNumber.getText());
    //HolidayManager.RequestHoliday(id, number);
    message.setText("Wohoo!");    
  }  

  /*public static void main(String[] args)
  {
    RequestHolidayGUI RHGui = new RequestHolidayGUI();
    RHGui.setVisible(true);
  }*/
}
