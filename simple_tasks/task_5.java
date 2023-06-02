import java.util.Scanner;

public class Task_5_m {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int n = sc.nextInt();
        int maleCount = 0, femaleCount = 0, maleSalarySum = 0, femaleSalarySum = 0;
        float salaries[][] = new float[n][2];
        for (int i = 0; i < salaries.length; i++) { // Create a loop for the list of lists (iterate for each person)
            for (int j = 0; j < salaries[0].length; j++) { // Create a loop for the lists within the main list (iterate for each person)
                if (j == 0) { // Condition only holds true the first time
                    System.out.print("Enter the gender (0 for male, 1 for female) of person " + (i + 1) + ": ");
                    salaries[i][j] = sc.nextFloat(); // Request input and store it for gender in position 0
                }
                if (j == 1) {
                    System.out.print("Enter the salary: ");
                    salaries[i][j] = sc.nextFloat(); // Request input and store it for salary in position 1
                }
            }
        }
        for (int i = 0; i < salaries.length; i++) { // Create a loop to iterate through all the workers (list of lists)
            if (salaries[i][0] == 0.0) { // If element 0 at index i represents a male
                maleCount++; // Increment the total number of males by 1
                maleSalarySum += salaries[i][1]; // Create a sum of total salaries for males
            }
            if (salaries[i][0] == 1.0) { // Same as above, but for females
                femaleCount++;
                femaleSalarySum += salaries[i][1];
            }
        }
        System.out.println("The average salary for males is: " + (maleSalarySum / maleCount));
        System.out.println("The average salary for females is: " + (femaleSalarySum / femaleCount));
    }
}
