public class Task_2_m {
    public static void main(String[] args) {
        int x = 1; // Create a counter to interact with the matrix data
        int m[][] = new int[10][10]; // Create a list of lists (10 lists within a main list)
        for (int i = 0; i < m.length; i++) { // Create a loop to iterate over the main list
            for (int j = 0; j < m[0].length; j++) { // Create a loop to iterate within each sublist
                m[i][j] = x * (j + 1); // Take each element of the sublist, associate it with the value of X
                System.out.printf("%4d", m[i][j]);
            }
            x++; // Increment the counter value to access the next multiplication table
            System.out.println("");
        }
    }
}
