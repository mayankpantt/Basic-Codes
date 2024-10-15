import java.util.Scanner;
    //using recursion

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the series: ");
        int number = scanner.nextInt();
        System.out.println("Fibonacci series is: " );
        scanner.close();
        for (int i = 0; i < number; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }