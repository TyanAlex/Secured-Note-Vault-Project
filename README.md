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


## 🚀 Getting Started

### 🔧 Requirements
- Java Development Kit (JDK 17+)
- Any Java IDE (IntelliJ, Eclipse, or VSCode)

Run the app starting with:

java LoginWindow


## 📌 Future Improvements

- Implement stronger password encryption using hashing algorithms
- Add timestamp and note categorization
- Support for deleting and renaming notes
- Add GUI styling/themes


