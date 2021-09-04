import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PasswordChecker extends JFrame {

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
    private boolean meetsRequirement = false;
    private boolean adminmeetsRequirement = false;


    public PasswordChecker() {

        Container psswrdInfo = getContentPane();

            psswrdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        psswrdIdentifier.setColumns(50);
        UserTextField.setColumns(6);
        psswrdPanel.add(Username);
        psswrdPanel.add(UserTextField);
        psswrdPanel.add(Password);
        psswrdPanel.add(psswrdIdentifier);
        psswrdPanel.add(insertInformationButton);
        psswrdInfo.add("North", NorthPanel);
        NorthPanel.add(psswrdTitle);

        psswrdInfo.add("Center", psswrdPanel);
        SouthPanel.add(lblpsswrdIdentifier);
        psswrdInfo.add("South", SouthPanel);


        this.insertInformationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String data = "";
                String userData = "";
                boolean needswork = false;
                data = new String(psswrdIdentifier.getPassword());
                userData =  new String(UserTextField.getText());

                    if (data.length() < 8 && data.matches("^[0-9]+$") && userData.matches("^[normal]+$")) {
                        lblpsswrdIdentifier.setText("Normal password requires a length of 8 and charcters");

                    } else if (data.length() < 8 && data.matches("^[a-z]+$") && userData.matches("^[normal]+$")) {
                        lblpsswrdIdentifier.setText("Normal password requires a length of 8 and numbers");
                        System.out.println(data);
                    } else if (data.matches("^[a-z]+$") && userData.matches("^[normal]+$")) {
                        lblpsswrdIdentifier.setText("Normal password requires numbers");

                    } else if (data.matches("^[0-9]+$") && userData.matches("^[normal]+$")) {
                        lblpsswrdIdentifier.setText("Normal password requires charcters");

                    } else if (data.length() < 8 && data.matches("^[0-9]+$") && data.matches("^[a-z]+$") && userData.matches("^[normal]+$")) {

                        lblpsswrdIdentifier.setText(" Normal password requires a length of 8 with numbers and characters");
                        meetsRequirement = true;
                    } else if (data.length() >= 8 &&  userData.matches("^[normal]+$"))   {
                        lblpsswrdIdentifier.setText("normal Password requirement worked");
                        psswrdIdentifier.setText("");
                        UserTextField.setText("");

                    }


                    if (data.length() < 13 && data.matches("^[a-z]+$") && userData.matches("^[admin]+$") && data.matches("^[!-*]+$")) {
                        lblpsswrdIdentifier.setText("Admin password requires a length of 13 and numbers with specialcharacters");

                    } else if (data.matches("^[a-z]+$") && userData.matches("^[admin]+$")) {
                        lblpsswrdIdentifier.setText("Admin password requires numbers");

                    } else if (data.matches("^[0-9]+$") && userData.matches("^[admin]+$")) {

                        lblpsswrdIdentifier.setText("Admin password requires charcters");

                    } else if (data.length() < 13 && data.matches("^[0-9]+$") && data.matches("^[a-z]+$") && userData.matches("^[admin]+$")) {
                        lblpsswrdIdentifier.setText("ADmin password requires a length of 8 with numbers and characters");
                        adminmeetsRequirement = true;
                    }

                    else if (data.length() >= 13 &&  userData.matches("^[admin]+$"))   {
                        lblpsswrdIdentifier.setText("admin Password requirement worked");
                        psswrdIdentifier.setText("");
                        UserTextField.setText("");

                    }










            }
        });


        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(1000,900);
        show();


    }


}
