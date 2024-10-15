import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
 //using two pointers to check if the string is a palindrome
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String testString = scanner.nextLine();
        System.out.println(testString + " is palindrome? " + isPalindrome(testString));
        scanner.close();
    }
}