import java.util.Scanner;

public class Task_3_m {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, greater = 0, smaller = 0, zero = 0;
        System.out.println("Enter number of rows");
        n = sc.nextInt();
        System.out.println("Enter number of columns");
        m = sc.nextInt();
        int matrix[][] = new int[n][m]; // Create the matrix based on the input values
        for (int i = 0; i < matrix.length; i++) { // Create a loop for the list of lists
            for (int x = 0; x < matrix[0].length; x++) { // Create a loop for the list within the main list
                System.out.println("Enter value for row: " + (i + 1) + " Column: " + (x + 1));
                matrix[i][x] = sc.nextInt(); // Prompt for inputs to fill the lists
                if (matrix[i][x] < 0) { // Add 1 to a variable for each value less than 0
                    smaller++;
                } else if (matrix[i][x] > 0) { // Add 1 to a variable for each value greater than 0
                    greater++;
                } else { // Add 1 to a variable for each value equal to 0
                    zero++;
                }
            }
        }
        System.out.printf("Greater: %d%nSmaller: %d%nEqual to zero: %d%n", greater, smaller, zero);
    }
}
