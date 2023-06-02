import java.util.Scanner;

public class Task_9_m {
    public static void main(String[] args) {
        int[] vector = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value to insert: ");
        int value = sc.nextInt();
        int x = vector.length - 1;
        System.out.printf("Enter the position where you want to insert (0 to %d): ", x);
        int position = sc.nextInt();
        if (position < 0 || position >= vector.length) { // Check if the requested position is within the list length
            System.out.println("The specified position does not exist. Exiting...");
        } else {
            for (int i = vector.length - 1; i > position; i--) { // Create a loop to iterate within the list and shift the values
                vector[i] = vector[i - 1]; // ABAJO
                // Since we are going from left to right, each value is replaced by the previous value,
                // starting from the second-last value and ending with the value at the specified position.
            }
            vector[position] = value; // Store the new value at the specified position

            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i] + " "); // Print all the values in the updated vector
            }
        }
    }
}
