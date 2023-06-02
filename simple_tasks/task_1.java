public class Task_1 {
    public static void main(String[] args) {
        int x = 1; // Create a counter starting from 1
        int m[][] = new int[5][5]; // Create a 5 x 5 matrix
        for (int i = 0; i < m.length; i++) { // Create a loop for the first "list"
            for (int j = 0; j < m[0].length; j++) { // Create a loop for the second "list"
                m[i][j] = x++; // Add the value of X to each position in the inner list
                System.out.printf("%4d", m[i][j]); // Print the summed values in 4d format
            }
            System.out.println("");
        }
    }
}
