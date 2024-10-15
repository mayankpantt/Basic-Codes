import java.util.Arrays;

//define an array and then search all the values that are less than a certain value and then print them in  a new array.
// make three functions, one to search the elementd, another to add/append the elements into the new array,//
//and then the third to sort the array and print it.
public class LinearSearch2 {

    public static void main(String[] args) {
        int[] array = {10, 20, 5, 15, 30, 25};
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the threshold value: ");
        int threshold = scanner.nextInt();
        scanner.close();
        int[] result = searchLessThan(array, threshold);
        
        Arrays.sort(result); // Sort the array before printing
        
        System.out.println("Values less than " + threshold + ":");
        printArray(result);
    }
    
    public static int[] searchLessThan(int[] array, int threshold) {
        int count = 0;
        for (int value : array) {
            if (value < threshold) {
                count++;
            }
        }
        
        int[] result = new int[count];
        int index = 0;
        for (int value : array) {
            if (value < threshold) {
                result[index++] = value;
            }
        }
        
        return result;
    }
    
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
