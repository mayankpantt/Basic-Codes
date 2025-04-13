import java.util.*;

public class PlayfairCipher {
    private char[][] keySquare;
    private static final int SIZE = 5;

    public PlayfairCipher(String key) {
        keySquare = generateKeySquare(key);
    }

    private char[][] generateKeySquare(String key) {
        key = key.toUpperCase().replaceAll("J", "I");
        Set<Character> used = new LinkedHashSet<>();
        for (char c : key.toCharArray()) {
            if (Character.isLetter(c)) {
                used.add(c);
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J') {
                used.add(c);
            }
        }
        char[][] square = new char[SIZE][SIZE];
        Iterator<Character> iter = used.iterator();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                square[i][j] = iter.next();
            }
        }
        return square;
    }

    private int[] findPosition(char letter) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (keySquare[i][j] == letter) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    private String processText(String text, boolean encrypt) {
        text = text.toUpperCase().replaceAll("J", "I").replaceAll("[^A-Z]", "");
        StringBuilder processedText = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = (i + 1 < text.length()) ? text.charAt(i + 1) : 'Z';
            if (first == second) {
                second = 'X';
                i--;
            }
            processedText.append(encryptPair(first, second, encrypt));
        }
        return processedText.toString().toLowerCase();
    }

    private String encryptPair(char first, char second, boolean encrypt) {
        int[] pos1 = findPosition(first);
        int[] pos2 = findPosition(second);
        int shift = encrypt ? 1 : -1;

        if (pos1[0] == pos2[0]) {
            return "" + keySquare[pos1[0]][(pos1[1] + shift + SIZE) % SIZE] +
                    keySquare[pos2[0]][(pos2[1] + shift + SIZE) % SIZE];
        } else if (pos1[1] == pos2[1]) {
            return "" + keySquare[(pos1[0] + shift + SIZE) % SIZE][pos1[1]] +
                    keySquare[(pos2[0] + shift + SIZE) % SIZE][pos2[1]];
        } else {
            return "" + keySquare[pos1[0]][pos2[1]] + keySquare[pos2[0]][pos1[1]];
        }
    }

    public String encrypt(String plaintext) {
        return processText(plaintext, true);
    }

    public String decrypt(String ciphertext) {
        return processText(ciphertext, false);
    }

    public void printKeySquare() {
        for (char[] row : keySquare) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the key for Playfair Cipher:");
        String key = scanner.nextLine();
        PlayfairCipher cipher = new PlayfairCipher(key);

        System.out.println("Generated Key Square:");
        cipher.printKeySquare();

        System.out.println("Enter the text to encrypt:");
        String plaintext = scanner.nextLine();
        String encrypted = cipher.encrypt(plaintext);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        scanner.close();
    }
}