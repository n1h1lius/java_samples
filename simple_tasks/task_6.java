import java.util.Arrays;

public class Task_6_m {
    public static void main(String[] args) {
        float[] vector = {1, 2, 3, 4, 5, 6};
        float[] evenNumbers;
        float[] oddNumbers;
        int evenCount = 0, oddCount = 0, evenPosition = 0, oddPosition = 0;

        for (int i = 0; i < vector.length; i++) { // Create a loop to iterate through the vector and count even and odd numbers
            if (vector[i] % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        evenNumbers = new float[evenCount]; // Create a list with the length of evenCount to store even numbers
        oddNumbers = new float[oddCount]; // Create a list with the length of oddCount to store odd numbers

        for (int i = 0; i < vector.length; i++) { // Create a loop to iterate through the vector of numbers
            if (vector[i] % 2 == 0) {
                evenNumbers[evenPosition] = vector[i]; // Store the value of vector[i] in the evenNumbers list at position evenPosition if it is even
                evenPosition++; // Increment evenPosition by 1 to access the next position in evenNumbers
            } else {
                oddNumbers[oddPosition] = vector[i]; // Same as above but for odd numbers
                oddPosition++;
            }
        }

        Arrays.sort(evenNumbers); // Sort even numbers in ascending order
        // Arrays.sort(oddNumbers) -> Descending sorting is not supported with .sort

        float[] result = new float[evenNumbers.length + oddNumbers.length];

        for (int i = 0; i < evenNumbers.length; i++) { // Create a loop to iterate through the evenNumbers list where the values are sorted
            result[i] = evenNumbers[i]; // Store the even number value from evenNumbers[i] in the result list at position i
        }

        for (int i = 0; i < oddNumbers.length; i++) { // Create a loop to iterate through the oddNumbers list where the values are not sorted
            result[i + evenNumbers.length] = oddNumbers[oddNumbers.length - 1 - i]; // ABAJO
            // A -> In result, insert i + length of evenNumbers to determine the correct position based on the previously stored data
            // B -> In oddNumbers, iterate from the end to the beginning to sort the values from highest to lowest, for that subtract i - 1 from the length of oddNumbers
        }

        for (int i = 0; i < result.length; i++) { // Loop to iterate through the result list
            System.out.print(result[i] + " "); // Print all the values together
        }
    }
}
