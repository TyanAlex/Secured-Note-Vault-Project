 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class UserManager {

    private static final String USER_FILE = "users.txt";
    private static HashMap<String, String> users = new HashMap<>();
    private static final int SHIFT_AMOUNT = 3;

    static {
        loadUsersFromFile();
    }

    public static boolean userRegister(String username, String password) {
        if (users.containsKey(username)) {
            return false;  // User already exists
        }

        String encryptedPassword = encryptPassword(password);
        users.put(username, encryptedPassword);

        saveUsersToFile();
        File userDir = new File("vault/" + username);
        if (!userDir.exists()) {
            userDir.mkdirs(); // Create a directory for the user
        }

        return true;
    }

    public static boolean isValidUser(String username, String password) {
        if (users.containsKey(username)) {
            String encryptedPassword = users.get(username);
            String decryptedPassword = decryptPassword(encryptedPassword);
            return decryptedPassword.equals(password);
        }
        return false;
    }

    private static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            char encryptedChar = (char) (c + SHIFT_AMOUNT);
            encrypted.append(encryptedChar);
        }
        return encrypted.toString();
    }

    private static String decryptPassword(String encryptedPassword) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encryptedPassword.length(); i++) {
            char c = encryptedPassword.charAt(i);
            char decryptedChar = (char) (c - SHIFT_AMOUNT);
            decrypted.append(decryptedChar);
        }
        return decrypted.toString();
    }

    private static void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    String encryptedPassword = parts[1];
                    users.put(username, encryptedPassword);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }

    private static void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            Set<String> userKeys = users.keySet();
            for (String username : userKeys) {
                String encryptedPassword = users.get(username);
                writer.write(username + "," + encryptedPassword);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }
}