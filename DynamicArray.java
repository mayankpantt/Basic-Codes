/*Dynamic Array
1. take any array(size of that array should be defined)
2. define tracker
3. initialize array[size]
4. insert and element:
	→first we will check [tracker+1 < size], if it's true then array[tracker+1] = n
    →if it is false then we will double the size of the array and then copy all the elements
     of the initial array into the new array and then insert the value that we wanted to insert into that new array	*/

public class DynamicArray {
    private int size;         // Size of the array
    private int tracker;      // Tracks the current position of the last inserted element
    private int[] array;      // Array to store the elements

    // Constructor to initialize the array with a given initial array
    public DynamicArray(int[] initialArray) {
        this.size = initialArray.length;
        this.tracker = size - 1;  // Last element's position
        this.array = initialArray.clone();  // Clone the initial array to avoid external modifications
    }

    // Method to insert an element into the array
    public void insert(int n) {
        if (tracker + 1 < size) {
            // If there's space, insert the element
            array[++tracker] = n;
        } else {
            // Double the size of the array
            size *= 2;
            int[] newArray = new int[size];

            // Copy old elements to the new array
            for (int i = 0; i <= tracker; i++) {
                newArray[i] = array[i];
            }

            // Update the reference to the new array
            array = newArray;

            // Insert the new element
            array[++tracker] = n;
        }
    }

    // Method to display the elements in the array
    public void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i <= tracker; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Define the initial array
        int[] initialArray = {19, 520, 24};

        // Initialize the dynamic array with the initial array
        DynamicArray dynamicArray = new DynamicArray(initialArray);

        // Insert elements
        dynamicArray.insert(45);  // This will trigger resizing

        // Display the elements
        dynamicArray.display();
    }
}
