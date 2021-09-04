import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PasswordChecker extends JFrame {

    //defining what goes into the JFrame
    // I liked Jframe because i felt it had better security
    private JPasswordField psswrdIdentifier = new JPasswordField ();
    private JTextField UserTextField = new JTextField();
    private JLabel psswrdTitle = new JLabel("Password Coding Assignement");
    private JButton insertInformationButton = new JButton("Insert the Information");
    private JLabel lblpsswrdIdentifier = new JLabel();
    private JLabel Username = new JLabel("Username");
    private JLabel Password = new JLabel("Password");
    private JPanel psswrdPanel = new JPanel();
    private JPanel SouthPanel = new JPanel();
    private JPanel NorthPanel = new JPanel();


    public PasswordChecker() {

        //defines each panel and what is contained within each.
        //important so my formating isnt messed up
        Container psswrdInfo = getContentPane();
        psswrdInfo.add("North", NorthPanel);
        NorthPanel.add(psswrdTitle);

        psswrdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        psswrdIdentifier.setColumns(50);
        UserTextField.setColumns(6);
        psswrdPanel.add(Username);
        psswrdPanel.add(UserTextField);
        psswrdPanel.add(Password);
        psswrdPanel.add(psswrdIdentifier);
        psswrdPanel.add(insertInformationButton);
        psswrdInfo.add("Center", psswrdPanel);

        SouthPanel.add(lblpsswrdIdentifier);
        psswrdInfo.add("South", SouthPanel);

        //where i defined the buttons purpose
        this.insertInformationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                //used two strings to hold both the password and users text.
                String data = "";
                String userData = "";

                //This is where I defined where the username and password
                data = new String(psswrdIdentifier.getPassword());
                userData =  new String(UserTextField.getText());

                    //Set up a loop that went through each of the requirments
                    if (data.length() < 10 && data.matches("^[a-z]+$") && userData.matches("^[normal]+$"))
                    {
                        lblpsswrdIdentifier.setText("Normal password requires a length of 10 and numbers");
                    } else if (data.matches("^[a-z]+$") && userData.matches("^[normal]+$")) {
                        lblpsswrdIdentifier.setText("Normal password requires numbers");
                    }
                    else if(data.length() < 10 && data.matches("^[0-9]+$") &&  userData.matches("^[normal]+$"))
                    {
                        lblpsswrdIdentifier.setText(" Normal password requires a length of 10 with characters ");
                    }
                    else if (data.matches("^[0-9]+$") && userData.matches("^[normal]+$"))
                    {
                        lblpsswrdIdentifier.setText("Normal password requires charcters");
                    }
                    else if(data.length() < 10  && userData.matches("^[normal]+$"))
                    {
                        lblpsswrdIdentifier.setText("Normal password requires a length of 10");
                    }
                    // stops the loop and tells the user when the password is successful
                    else if (data.length() >= 10 &&  userData.matches("^[normal]+$"))
                    {
                        lblpsswrdIdentifier.setText("normal Password requirement worked");
                        psswrdIdentifier.setText("");
                        UserTextField.setText("");
                    }

                        // starts the loop to determine if the admin password is acceptable
                      if (data.length() < 13 && data.matches("^[a-z]+$") && userData.matches("^[admin]+$"))
                      {
                    lblpsswrdIdentifier.setText("Admin password requires a length of 13 including numbers and 1 special character");
                      }
                     else if (data.matches("^[a-z]+$") && userData.matches("^[admin]+$"))
                     {
                        lblpsswrdIdentifier.setText("Admin password requires numbers and 3 special character");
                     }
                     else if (data.length() < 13 && data.matches("^[0-9]+$") && userData.matches("^[admin]+$"))
                     {
                          lblpsswrdIdentifier.setText("Admin password requires a length of 13 including characters and 3 special character");
                     }
                     else if (data.matches("^[0-9]+$") && userData.matches("^[admin]+$"))
                     {

                        lblpsswrdIdentifier.setText("Admin password requires charcters and 3 special character");
                    }
                     else if(data.length() < 13 && data.matches("^[!-*]+$") && userData.matches("^[admin]+$"))
                     {
                          lblpsswrdIdentifier.setText("Admin password requires length of 13 including numbers, characters");
                     }
                      else if(data.matches("^[!-*]+$") && userData.matches("^[admin]+$"))
                      {
                          lblpsswrdIdentifier.setText("Admin password requires numbers, characters");
                      }

                     else if (data.length() < 13  && userData.matches("^[admin]+$"))
                     {
                        lblpsswrdIdentifier.setText("Admin password requires a length of 13");
                    }
                     //ends loop and checks to see if the password has 3 special characters
                    else if (data.length() >= 13 &&  userData.matches("^[admin]+$") && data.matches("^.*[!-*].*[!-*].*[!-*]+$"))
                    {
                        lblpsswrdIdentifier.setText("admin Password requirement worked");
                        psswrdIdentifier.setText("");
                        UserTextField.setText("");
                    }

            }
        });

/// closes when exiting window
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(1000,900);
        show();


    }

}
