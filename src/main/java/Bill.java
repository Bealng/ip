import java.util.Scanner;

/**
 * Greets the user, echoes their input, and exits when they enter "bye".
 */
public class Bill {
    public static void main(String[] args) {
        String banner = " ____  _ _ _ \n"
                + "| __ )(_) | |\n"
                + "|  _ \\| | | |\n"
                + "| |_) | | | |\n"
                + "|____/|_|_|_|\n";
        String horizontalLine = "____________________________________________________________";

        System.out.println(horizontalLine);
        System.out.print(banner);
        System.out.println("Hello! I'm Bill.");
        System.out.println("What can I do for you?");
        System.out.println(horizontalLine);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            System.out.println(input);
            System.out.println(horizontalLine);
            input = scanner.nextLine();
        }

        System.out.println("Bye. Have a good day mate!");
        System.out.println(horizontalLine);
    }
}
