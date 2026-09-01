import java.util.Scanner;

/**
 * Greets the user and manages tasks until the user enters "bye".
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
        boolean[] isDone = new boolean[100];
        int taskCount = 0;
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    String status = isDone[i] ? "[X]" : "[ ]";
                    System.out.println((i + 1) + "." + status + " " + tasks[i]);
                }
            } else if (input.startsWith("mark ")) {
                int taskIndex = Integer.parseInt(input.substring(5)) - 1;
                isDone[taskIndex] = true;
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  [X] " + tasks[taskIndex]);
            } else if (input.startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(input.substring(7)) - 1;
                isDone[taskIndex] = false;
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  [ ] " + tasks[taskIndex]);
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
