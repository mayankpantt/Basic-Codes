import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the limit of numbers: ");
        int limit = scanner.nextInt();
        
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if (num > limit) {
                    break;
                }
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
            if (num > limit) {
                break; //when the limit is reached the number of rows are disregarded
                // num = 1; //reset the number to 1
            }
        }
        
        scanner.close();
    }
}
