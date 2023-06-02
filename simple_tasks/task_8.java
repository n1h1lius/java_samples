import java.util.Scanner;

public class Task_10_m {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int[] vector = new int[100]; // Create a list of length 100
        do {
            System.out.println("Enter a number from 1 to 100: ");
            number = sc.nextInt();
            if (number < 1 || number > 100) {
                System.out.println("The entered number is incorrect... exiting");
                break;
            } else {
                vector[number - 1]++; // Find the position within the vector of the entered number and increment it by 1
                // Since the base value is 0, we increment it by 1 each time that number has been entered as input
            }
        } while (number >= 1 || number <= 100); // Loop to continue asking for inputs

        System.out.println("Value Count");
        for (int i = 0; i < vector.length; i++) { // Iterate within the vector list that contains values from 1 to 100
            if (vector[i] > 0) { // If the element at index i in the vector list is greater than 0, it means that number has been entered one or more times
                System.out.print(i + 1 + ": ");
                for (int j = 0; j < vector[i]; j++) { // Create a loop to print as many asterisks as the number of times the number i has been repeated
                    System.out.print("*");
                }
                System.out.println(" ");
            }
        }
    }
}
