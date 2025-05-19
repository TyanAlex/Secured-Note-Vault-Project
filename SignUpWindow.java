 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpWindow extends JFrame {
 private JTextField userField;
 private JPasswordField passField;

    public SignUpWindow() {
        setTitle("Sign Up");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel userLabel = new JLabel("Username:");
         userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
         passField = new JPasswordField();

        

        JButton registerButton = new JButton("Register");
        JButton backToLoginButton = new JButton("Back to Login");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
      
        
        panel.add(registerButton);
        panel.add(backToLoginButton);

        add(panel);

          //register button action listener 

          registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usrName = userField.getText();
                String pwd = new String(passField.getPassword());

                if(UserManager.userRegister(usrName, pwd)) {
                    JOptionPane.showMessageDialog(SignUpWindow.this, "Registered successfully!");
                    new LoginWindow();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(SignUpWindow.this, "Account already registered!");
                }
            }
        });

        // back to login action listener
        backToLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginWindow();
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpWindow();
    }
}