import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PasswordChecker extends JFrame {

    private JPasswordField  informationTextField = new JPasswordField ();
    private JButton insertInformationButton = new JButton("Insert the Information");
    private JLabel northLabel = new JLabel();
    private JPanel psswrdPanel = new JPanel();
    private JPanel SouthPanel = new JPanel();
    private JPanel NorthPanel = new JPanel();
    private boolean meetsRequirement = true;
    private String[] numbers =
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8",
                    "9"
            };
    private String[] letters =
            {
                    "a",
                    "b",
                    "c",
                    "d",
                    "e",
                    "f",
                    "g",
                    "h",
                    "i",
                    "j",
                    "k",
                    "l",
                    "n",
                    "o",
                    "p",
                    "q",
                    "r",
                    "s",
                    "t",
                    "u",
                    "v",
                    "w",
                    "x",
                    "y",
                    "z"
            };


    public PasswordChecker() {

        Container psswrdInfo = getContentPane();

            psswrdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        informationTextField.setColumns(50);
        psswrdPanel.add(informationTextField);
        psswrdPanel.add(insertInformationButton);
        psswrdPanel.add(northLabel);
        psswrdInfo.add("North", NorthPanel);
        psswrdInfo.add("Center", psswrdPanel);
        psswrdInfo.add("South", SouthPanel);


        this.insertInformationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String data = "";
                String number = "";
                int intNumber = 0;

                data = new String(informationTextField.getPassword());

                if(data.length() < 8 || data.matches("^[0-9]+$") || data.matches("^[a-z]+$")  )
                {
                    northLabel.setText("Password requirement failed");
                }
                else
                {
                    System.out.println(data);
                    northLabel.setText("Password requirement worked");
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
