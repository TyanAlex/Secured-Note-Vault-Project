 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NoteVaultPanel extends JPanel {

    private JTextArea textArea;
    private DefaultListModel<String> fileListModel;
    private JList<String> fileList;
    private String currentUser;
    private JLabel statusLabel;
    private JTextField fileNameField;

    private JButton saveButton;
    private JButton loadButton;
    private JButton deleteButton;
    private JButton signOutButton;
    private JButton browseButton;

    public NoteVaultPanel(String username) {
        this.currentUser = username;
        setLayout(new BorderLayout());

        // Top: File name input
        fileNameField = new JTextField();
        fileNameField.setBorder(BorderFactory.createTitledBorder("File Name"));
        add(fileNameField, BorderLayout.NORTH);

        // Center: Note area
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);


        // Right side: File list
        fileListModel = new DefaultListModel<>();
        fileList = new JList<>(fileListModel);
        fileList.setBorder(BorderFactory.createTitledBorder("Saved Files"));
        fileList.setPreferredSize(new Dimension(150, 0));
        add(new JScrollPane(fileList), BorderLayout.EAST);

        // Left side: Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 10));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        deleteButton = new JButton("Delete");
        signOutButton = new JButton("Sign Out");
        browseButton = new JButton("Browse");

        Dimension buttonSize = new Dimension(90, 20);
        
        saveButton.setPreferredSize(buttonSize);
        loadButton.setPreferredSize(buttonSize);
        deleteButton.setPreferredSize(buttonSize);
        signOutButton.setPreferredSize(buttonSize);
        browseButton.setPreferredSize(buttonSize);

        buttonPanel.add(saveButton);
       
        buttonPanel.add(loadButton);
       
        buttonPanel.add(deleteButton);
   
        buttonPanel.add(signOutButton);
        buttonPanel.add(browseButton);

        add(buttonPanel, BorderLayout.WEST);

        // Bottom: Status label
        statusLabel = new JLabel("Welcome, " + currentUser + "!");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        add(statusLabel, BorderLayout.SOUTH);

        // Load files on start
        refreshFileList();

        // Save button action
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText().trim();
                if (!fileName.isEmpty()) {
                    NoteLogic.saveNote(currentUser, textArea, fileName, statusLabel);
                    refreshFileList();
                } else {
                    statusLabel.setText("File name cannot be empty.");
                }
            }
        });

        // Load button action
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedFile = fileList.getSelectedValue();
                if (selectedFile != null) {
                    NoteLogic.loadNote(currentUser, textArea, selectedFile, statusLabel);
                    fileNameField.setText(selectedFile);
                } else {
                    statusLabel.setText("No file selected to load.");
                }
            }
        });


        //browse button action 
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(new File("vault/" + currentUser));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));

                int result = fileChooser.showOpenDialog(NoteVaultPanel.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();
                    fileNameField.setText(fileName);
                    NoteLogic.loadNote(currentUser, textArea, fileName, statusLabel);
                }
            }
        });


        // Delete button action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedFile = fileList.getSelectedValue();
                if (selectedFile != null) {
                    NoteLogic.deleteNote(currentUser, textArea, selectedFile, statusLabel, fileNameField);
                    refreshFileList();
                    textArea.setText("");
                } else {
                    statusLabel.setText("No file selected to delete.");
                }
            }
        });

        // Sign Out button action
        signOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(NoteVaultPanel.this);
                topFrame.dispose(); // Close current window
                new LoginWindow();  // Reopen login screen
            }
        });

    }

    private void refreshFileList() {
        fileListModel.clear();
        File userDir = new File("vault/" + currentUser);
        if (userDir.exists() && userDir.isDirectory()) {
            File[] files = userDir.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    fileListModel.addElement(files[i].getName());
                }
            }
        }
    }
}