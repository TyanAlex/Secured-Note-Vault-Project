 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String USER_FILES_DIRECTORY = "user_files/";

    // loading files for the logged in user
    public static List<String> loadUserFiles(String username) {
        List<String> userFiles = new ArrayList<>();
        File directory = new File(USER_FILES_DIRECTORY);

        // checking if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // filtering by username 
            File[] files = directory.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.startsWith(username);
                }
            });

            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    userFiles.add(files[i].getName());
                }
            }
        }
        return userFiles;
    }
}