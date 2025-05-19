 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame {
    public LoginWindow() {
        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signUpButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usr = usernameField.getText();
                String pwd = new String(passwordField.getPassword());

                if (UserManager.isValidUser(usr, pwd)) {
                    dispose();
                    new NoteVaultFrame(usr);
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Invalid login.");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUpWindow();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}