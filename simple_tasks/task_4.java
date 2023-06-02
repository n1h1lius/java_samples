import java.util.Scanner;

public class Task_4_m {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float grades[][] = new float[4][5]; // Create a list of lists in float to store the grades
        float minimum = 0, maximum = 0, average = 0, sum = 0; // Create float variables for grades
        for (int i = 0; i < grades.length; i++) { // Create a loop for the list of lists (students)
            for (int j = 0; j < grades[0].length; j++) { // Create a loop for the lists within the main list (grades)
                System.out.print("For student " + (i + 1) + ", enter grade " + (j + 1) + ": ");
                grades[i][j] = sc.nextFloat(); // Store the float input in the grades list
                sum += grades[i][j]; // Add all the data to the sum variable as a summation function
                if (j == 0) { // Condition that only executes on the first iteration
                    minimum = grades[i][j]; // Assign the first value to the minimum variable
                    maximum = grades[i][j]; // Assign the first value to the maximum variable
                }
                if (minimum > grades[i][j]) { // Compare the minimum variable with the current value
                    minimum = grades[i][j]; // If the current value is smaller than the previous minimum, update the minimum variable
                }
                if (maximum < grades[i][j]) { // Compare the maximum variable with the current value
                    maximum = grades[i][j]; // If the current value is greater than the previous maximum, update the maximum variable
                }
            }
            System.out.println();
            System.out.println("The minimum grade for student " + (i + 1) + " is: " + minimum);
            System.out.println("The maximum grade for student " + (i + 1) + " is: " + maximum);
            System.out.println("The average grade for student " + (i + 1) + " is: " + (sum / 5)); // Calculate the average by dividing the sum variable by the total number of subjects
            sum = 0; // Reset the sum variable to perform the summation with new grades, ensuring the average is specific to each student
            System.out.println("");
        }
    }
}
