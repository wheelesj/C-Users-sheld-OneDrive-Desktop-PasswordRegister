import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PasswordChecker extends JFrame {

    private JPasswordField psswrdIdentifier = new JPasswordField ();
    private JLabel psswrdTitle = new JLabel("Password Coding Assignement");
    private JButton insertInformationButton = new JButton("Insert the Information");
    private JLabel lblpsswrdIdentifier = new JLabel();
    private JPanel psswrdPanel = new JPanel();
    private JPanel SouthPanel = new JPanel();
    private JPanel NorthPanel = new JPanel();
    private boolean meetsRequirement = true;



    public PasswordChecker() {

        Container psswrdInfo = getContentPane();

            psswrdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        psswrdIdentifier.setColumns(50);
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
                String number = "";
                int intNumber = 0;

                data = new String(psswrdIdentifier.getPassword());


                if(data.length() < 8 && data.matches("^[0-9]+$")   )
                {
                    lblpsswrdIdentifier.setText("Password requires a length of 8 and charcters");
                }
                else if ( data.length() < 8 && data.matches("^[a-z]+$")  ) {
                    lblpsswrdIdentifier.setText("Password requires a length of 8 and numbers");
                }
                else if (data.matches("^[a-z]+$") )
                {
                    lblpsswrdIdentifier.setText("Password requires numbers");
                }
                else if( data.matches("^[0-9]+$"))
                {
                    lblpsswrdIdentifier.setText("Password requires charcters");
                }
                else if(data.length() < 8 || data.matches("^[0-9]+$") || data.matches("^[a-z]+$") )
                {
                    lblpsswrdIdentifier.setText("Requires a length of 8 with numbers and characters");
                }
                else {

                    lblpsswrdIdentifier.setText("Password requirement worked");
                    psswrdIdentifier.setText("");
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
