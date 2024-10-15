public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the value to search: ");
        int n = scanner.nextInt();
        scanner.close();
        int index = linearSearch(array, n);

        if (index != -1) {
            System.out.println("Value " + n + " found at index " + index);
        } else {
            System.out.println("Value " + n + " not found in the array");
        }
    }
    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}