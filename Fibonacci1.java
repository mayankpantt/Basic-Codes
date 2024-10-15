import java.util.Scanner;
    //without using recursion
public class Fibonacci1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci series: ");
        int n = scanner.nextInt();
        scanner.close();
        printFibonacciSeries(n);
    }

    public static void printFibonacciSeries(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b); // Print the first two numbers

        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(" " + next);
            // now for the next terms
            a = b;    
            b = next;
        }
    }
} 