import java.util.Scanner;

public class task_9 {
    public static double week[][] = new double[52][7];

    // Create a function that prints line breaks to display the menu more visually
    public static void clear() {
        System.out.println(new String(new char[100]).replace("\0", "\r\n"));
    }

    // Create a function to print a specific error for convenience
    public static void raise_error(int opt) {
        switch (opt) {
            case 1 -> System.out.println("ERROR: Invalid option entered, please try again\n");
            case 2 -> System.out.println("ERROR: No temperatures registered\n");
            case 3 -> System.out.println("ERROR: Invalid or impossible temperature entered. Please try again\n");
        }
    }

    // Create a function to filter the input from the main method and return the corresponding index
    public static int find_index(char opt) {
        char[] uppercase = {'R', 'M', 'D', 'S'};
        char[] lowercase = {'r', 'm', 'd', 's'};
        char[][] lists = {uppercase, lowercase};
        for (char[] list : lists) {
            int index = 0;
            for (char letter : list) {
                if (letter == opt) {
                    return index;
                } else {
                    index++;
                }
            }
        }
        return -1;
    }

    public static void registrer() {
        Scanner opt = new Scanner(System.in);
        System.out.println("Enter desired option -> ");
        String opt2 = opt.nextLine();
        String[] data = opt2.split(" ");
        System.out.println(data);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    Welcome to the temperature registry
                    --------------------------------------------
                    [R] Register weekly temperatures
                    [M] Check average temperature
                    [D] Check maximum difference
                    [S] Exit
                    """);
            Scanner opt = new Scanner(System.in);
            System.out.println("Enter desired option -> ");
            String opt2 = opt.nextLine();
            char[] var = opt2.toCharArray();
            if (var.length == 1) {
                char letter = var[0];
                int num = find_index(letter);
                if (num < 4 && num >= 0) {
                    switch (num) {
                        case 0:
                            registrer();
                            break;
                        case 1:
                            raise_error(2);
                            break;
                        case 2:
                            break;
                        case 3:
                            System.exit(1);
                            break;
                    }
                } else {
                    clear();
                    raise_error(1);
                }
            } else {
                clear();
                raise_error(1);
            }
        }
    }
}
