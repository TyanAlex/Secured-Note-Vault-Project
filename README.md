# Secured-Note-Vault-Project
Secure Note Vault is a Java Swing app for securely creating, saving, and managing personal notes. It features user authentication, encrypted note storage using Caesar cipher, and a simple file browser for loading and deleting saved notes.

## 📘 Overview

**Password Protected NoteApp** is a secure desktop application built in Java using Swing that allows users to create, view, and manage personal notes behind a password-protected login system.

Each user has a private note vault, and all credentials are securely encrypted using a Caesar-style shifting cipher.

---

## ✨ Features

- 🔐 **User Authentication**
  - Sign up with a unique username and password
  - Login validation with password decryption

- 📝 **Note Vault**
  - Create and save personal notes in your own vault
  - Edit and overwrite existing notes
  - Notes are stored in `.txt` format within user-specific folders

- 🔒 **Encryption**
  - Passwords are stored in a local file using basic encryption (Caesar Cipher with shift `+3`)

- 📁 **File Management**
  - A `vault/` directory is created per user
  - All notes and credentials are handled with file-based persistence

---

## 🛠️ Technologies Used

- Java 17+
- Java Swing (GUI)
- File I/O
- OOP principles (separation of concerns, modular design)

---

## 🗂️ Project Structure

PasswordProtectedNoteApp/

│

├── LoginWindow.java # User login interface

├── SignUpWindow.java # User registration interface

├── NoteVaultFrame.java # Main window after login

├── NoteVaultPanel.java # UI panel for note interaction

├── NoteLogic.java # File-based note handling logic

├── UserManager.java # Handles user creation, validation, encryption

├── ShiftingCipher.java # Caesar cipher encryption/decryption

├── users.txt # Stored usernames and encrypted passwords

├── vault/ # User-specific directories for notes

└── README.md # This file

---

## 🚀 Getting Started

### 🔧 Requirements
- Java Development Kit (JDK 17+)
- Any Java IDE (IntelliJ, Eclipse, or VSCode)

---

## Run the app starting with:

java NoteVaultUI

---

## Application Flow

- First create an account in the sign up window

<img width="395" alt="Screen Shot 2025-05-20 at 17 23 26" src="https://github.com/user-attachments/assets/974f7269-6acd-4c5e-93e2-b1738ffde446" />

If signed up successfully, the following message with be displayed

<img width="397" alt="Screen Shot 2025-05-20 at 17 23 49" src="https://github.com/user-attachments/assets/0301e0c6-c3d0-4703-92d7-342dea26921d" />

- Then login with your username and password 

<img width="400" alt="Screen Shot 2025-05-20 at 17 22 14" src="https://github.com/user-attachments/assets/57767357-1590-458e-aa29-a73cade405be" />

- Once logged in, the following window will open

<img width="800" alt="Screen Shot 2025-05-20 at 17 24 31" src="https://github.com/user-attachments/assets/47c9eeaa-3dd0-4696-ad2f-d7d9c014a4f3" />

- Create a file name and try writting something to the file in the main text area, then press save to save the file

<img width="803" alt="Screen Shot 2025-05-20 at 17 25 51" src="https://github.com/user-attachments/assets/07aac29d-4e40-4680-9ff1-68db55fff821" />

- Create as many files as you want (all created files are displayed in the window on the right)

<img width="796" alt="Screen Shot 2025-05-20 at 17 26 29" src="https://github.com/user-attachments/assets/5f08dfde-d9d3-43d2-a4ef-1658cf20beb7" />

- If a file needs to be loaded, select a file and press load button

<img width="799" alt="Screen Shot 2025-05-20 at 17 26 56" src="https://github.com/user-attachments/assets/892853c7-15d8-4078-bd8d-fbc400755ec7" />

- If would like to browse for files, you can use the browsing button

<img width="803" alt="Screen Shot 2025-05-20 at 17 27 37" src="https://github.com/user-attachments/assets/80b1def8-7b56-4e1d-b5fc-f4ce6f59c1f6" />

- If would want to delete a file, select a file and press delete button

<img width="801" alt="Screen Shot 2025-05-20 at 17 28 08" src="https://github.com/user-attachments/assets/e48d26bb-1eca-4737-afc9-89b180331c87" />

- To sign out or switch accounts, press sign out button which will navigate you back to login window

<img width="399" alt="Screen Shot 2025-05-20 at 17 29 24" src="https://github.com/user-attachments/assets/3b44befa-c669-4504-a490-de146cb29db8" />

---

## 📌 Future Improvements

- Implement stronger password encryption using hashing algorithms
- Add timestamp and note categorization
- Support for deleting and renaming notes
- Add GUI styling/themes


