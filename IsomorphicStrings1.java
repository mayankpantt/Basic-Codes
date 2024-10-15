import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings1 {
    public static boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // Check if mapping is consistent in both directions
            if (map1.containsKey(c1) && map1.get(c1) != c2) {
                return false;
            }
            if (map2.containsKey(c2) && map2.get(c2) != c1) {
                return false;
            }

            map1.put(c1, c2);
            map2.put(c2, c1);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();

        if (areIsomorphic(s1, s2)) {
            System.out.println("The strings are isomorphic.");
        } else {
            System.out.println("The strings are not isomorphic.");
        }

        scanner.close();
    }
}
