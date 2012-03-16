import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class LoginGui extends JFrame implements ActionListener 
{

  private JLabel promptLabel = new JLabel("Please select user type");
  private final JTextField usernameField = new JTextField(10);
  private final JTextField passwordField = new JTextField(10);
  private final JLabel usernameLabel = new JLabel("Username:");
  private final JLabel passwordLabel = new JLabel("Password:");
  private final JLabel userLabel = new JLabel("User:");
  private final JButton CancelButton = new JButton("Cancel");
  private final JButton LoginButton = new JButton("Login");
  private JRadioButton controllerOption = new JRadioButton("Controller", false);
  private JRadioButton driverOption = new JRadioButton("Driver", false);

  private JPanel buttonPanel = new JPanel(); 
  private JPanel inputPanel = new JPanel();
  private ButtonGroup group = new ButtonGroup();

  public LoginGui() 
  {
    setTitle("Login");
    setSize(400, 200);
    addWindowListener(new WindowAdapter() 
    {
      public void windowClosing(WindowEvent e) 
      {
        System.exit(0);
      }
    });


    inputPanel.add(promptLabel);
    inputPanel.add(usernameLabel);
    inputPanel.add(usernameField);
    usernameField.setVisible(false);
    usernameLabel.setVisible(false);
    inputPanel.add(passwordLabel);
    inputPanel.add(passwordField);
    passwordField.setVisible(false);
    passwordLabel.setVisible(false);

    buttonPanel.add(userLabel);
    group.add(controllerOption);
    buttonPanel.add(controllerOption);
    controllerOption.addActionListener(this);
    group.add(driverOption);
    buttonPanel.add(driverOption);
    driverOption.addActionListener(this);


    buttonPanel.add(LoginButton);
    LoginButton.addActionListener(this);

    buttonPanel.add(CancelButton);
    CancelButton.addActionListener(this);

    getContentPane().add(inputPanel, "North");
    getContentPane().add(buttonPanel, "South");

  }


  public void actionPerformed(ActionEvent evt) 
  {
    Object source = evt.getSource();

    if (source == controllerOption)
    {
      promptLabel.setVisible(false);
      passwordLabel.setVisible(true);
      passwordField.setVisible(true);
      usernameField.setVisible(false);
      usernameLabel.setVisible(false);
    } 
   
    else if (source == driverOption)
    {
      promptLabel.setVisible(false);
      usernameField.setVisible(true);
      usernameLabel.setVisible(true);
      passwordLabel.setVisible(false);
      passwordField.setVisible(false);
      if(source == LoginButton)
      {
        int UserID = Integer.parseInt(usernameField.getText);
	LoginManager user = new LoginManager(UserID);
      }
    } 
    
    else if (source == CancelButton)
    { 
      System.exit(0);
    }
  }



  public static void main(String[] args)
  {
    JFrame gui = new LoginGui();
    gui.show();
  }
}
