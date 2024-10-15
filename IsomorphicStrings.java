import java.util.Scanner;
//using nested loops

public class IsomorphicStrings {
    public static boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false; // If lengths differ, not isomorphic
        }

        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j < s1.length(); j++) {
                // If two characters in s1 are the same but their corresponding
                // characters in s2 differ, the strings are not isomorphic
                if (s1.charAt(i) == s1.charAt(j) && s2.charAt(i) != s2.charAt(j)) {
                    return false;
                }

                // If two characters in s2 are the same but their corresponding
                // characters in s1 differ, the strings are not isomorphic
                if (s2.charAt(i) == s2.charAt(j) && s1.charAt(i) != s1.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        if (areIsomorphic(str1, str2)) {
            System.out.println("The given strings are isomorphic.");
        } else {
            System.out.println("The given strings are not isomorphic.");
        }

        scanner.close();
    }
}
