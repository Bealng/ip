import java.util.Scanner;

/**
 * Greets the user, stores tasks, lists them on request, and exits on "bye".
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
        String[] tasks = new String[100];
        int taskCount = 0;
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
            } else {
                tasks[taskCount] = input;
                taskCount++;
                System.out.println("added: " + input);
            }
            System.out.println(horizontalLine);
            input = scanner.nextLine();
        }

        System.out.println("Bye. Have a good day mate!");
        System.out.println(horizontalLine);
    }
}
