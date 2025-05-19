 /* CSCI 185 M05
 * Final Programming Project: Password Protected NoteApp
 * Mohammed Abedin, Adil Ayman, Alex Tyan
 * Prof Li
 * May 12 2025
 */

//in our project we decided to use shifting cipher in order to keep things simple

public class ShiftingCipher {

    // shifts by 3
    private static final int SHIFT = 3;

    // encrypting method
    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        // looping through each character of input
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            //only for letter A-Z, a-z
            if (Character.isLetter(c)) {
                char shiftedChar = shiftChar(c, SHIFT);
                encrypted.append(shiftedChar);
            } else {
                //if not a letter (digit or symbol)
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    // decrypting method
    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        // looping through each character of input 
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            //only for letter A-Z, a-z
            if (Character.isLetter(c)) {
                //shifting back in the reerse direction
                char shiftedChar = shiftChar(c, -SHIFT); 
                decrypted.append(shiftedChar);
            } else {
                //if not a letter (digit or symbol)
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }

    // shiffting method
    private static char shiftChar(char c, int shift) {
        if (Character.isUpperCase(c)) {
            // uppercase letters A-Z
            return (char) (((c - 'A' + shift + 26) % 26) + 'A');
        } else if (Character.isLowerCase(c)) {
            //lowercase letters a-z
            return (char) (((c - 'a' + shift + 26) % 26) + 'a');
        }
        return c;  // Non-alphabetic characters are not shifted
    }
}