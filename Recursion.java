public class Recursion {

    public static void main(String[] args) {
        print(1);
    }
    //print from 1 to 10

    public static void print(int n) {
        if (n > 10) {
            return;
        }
        System.out.println(n);
        print(n + 1);
    }
}