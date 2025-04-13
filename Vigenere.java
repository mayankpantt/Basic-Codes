import java.util.Scanner;

public class Vigenere {
    
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                result.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
                j = (j + 1) % key.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                result.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
                j = (j + 1) % key.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Do you want to encrypt or decrypt? (E/D): ");
        String choice = scanner.nextLine().trim().toUpperCase();
        
        System.out.println("Enter the text: ");
        String text = scanner.nextLine();
        
        System.out.println("Enter the key: ");
        String key = scanner.nextLine();
        
        if (choice.equals("E")) {
            System.out.println("Encrypted: " + encrypt(text, key));
        } else if (choice.equals("D")) {
            System.out.println("Decrypted: " + decrypt(text, key));
        } else {
            System.out.println("Invalid choice. Please enter E for encryption or D for decryption.");
        }
        
        scanner.close();
    }
}
