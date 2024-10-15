import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static boolean areAnagrams(String str1, String str2) {
         // Remove spaces and convert to lowercase for comparison
         str1 = str1.replaceAll("\\s", "").toLowerCase();
         str2 = str2.replaceAll("\\s", "").toLowerCase();
 
         // Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        
        // Compare sorted character arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string:");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string:");
        String str2 = scanner.nextLine();

        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        scanner.close();
    }
}