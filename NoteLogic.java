 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

import javax.swing.*;
import java.io.*;

public class NoteLogic extends JFrame {
    private static final String DIRECTORY = "vault/";

    // Save note
    public static void saveNote(String username, JTextArea noteInput, String fileNameInput, JLabel statusLabel) {
        String content = noteInput.getText();

        if (content.isBlank()) {
            statusLabel.setText("Note is empty. Not saved.");
            return;
        }

        try {
            File dir = new File(DIRECTORY + username);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            FileWriter writer = new FileWriter(DIRECTORY + username + "/" + fileNameInput);
            writer.write(content);
            writer.close();
            statusLabel.setText("Note saved: " + fileNameInput);
        } catch (Exception e) {
            statusLabel.setText("Error saving note.");
        }
    }

    // Load note
    public static String loadNote(String username, JTextArea noteInput, String fileNameInput, JLabel statusLabel) {
        try {
            File file = new File(DIRECTORY + username + "/" + fileNameInput);
            if (!file.exists()) {
                statusLabel.setText("Note not found: " + fileNameInput);
                
            }

            FileReader fr = new FileReader(file);
            noteInput.read(fr, null);
            fr.close();
            statusLabel.setText("Note loaded: " + fileNameInput);
        } catch (Exception e) {
            statusLabel.setText("Error loading note.");
        }
        return "0";
    }

    // Delete note
    public static void deleteNote(String username, JTextArea noteInput, String fileNameInput, JLabel statusLabel, JTextField fileNameField) {
        try {
            File file = new File(DIRECTORY + username + "/" + fileNameInput);
            Object[] options = {"OK", "CANCEL"};

            if (file.exists() && !fileNameInput.isEmpty()) {
                int result = JOptionPane.showOptionDialog(null, "Are you sure you want to delete this file?", "Warning",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);

                if (result == JOptionPane.OK_OPTION) {
                    file.delete();
                    statusLabel.setText("File deleted: " + fileNameInput);
                    noteInput.setText("");
                    fileNameField.setText("");
                }
            } else {
                statusLabel.setText("File does not exist");
            }
        } catch (Exception e) {
            statusLabel.setText("Error deleting file");
        }
    }
}