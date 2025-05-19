 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

import javax.swing.*;

public class NoteVaultFrame extends JFrame {
    public NoteVaultFrame(String username) {
        setTitle("Secure Note Vault - Welcome " + username);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //display in the center
        setLocationRelativeTo(null);

        
        NoteVaultPanel panel = new NoteVaultPanel(username);
        add(panel);
        setVisible(true);
    }
}