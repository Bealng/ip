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
        System.out.println("Type 'help' if you'd like a tour of my commands.");
        System.out.println(horizontalLine);

        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = 0;
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("bye")) {
            String normalizedInput = input.toLowerCase();
            if (normalizedInput.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + "." + tasks[i]);
                }
            } else if (normalizedInput.equals("help")) {
                System.out.println("Here are the commands I understand:");
                System.out.println("  list          - show every task");
                System.out.println("  mark NUMBER   - mark a task as done");
                System.out.println("  unmark NUMBER - mark a task as not done");
                System.out.println("  stats         - show your progress");
                System.out.println("  bye           - exit Bill");
                System.out.println("  Any other text adds a new task.");
            } else if (normalizedInput.equals("stats")) {
                int completedCount = 0;
                for (int i = 0; i < taskCount; i++) {
                    if (tasks[i].isDone()) {
                        completedCount++;
                    }
                }
                int remainingCount = taskCount - completedCount;
                System.out.println("Task stats: " + taskCount + " total, "
                        + completedCount + " done, " + remainingCount + " remaining.");
            } else if (normalizedInput.startsWith("mark ")) {
                int taskIndex = Integer.parseInt(input.substring(5)) - 1;
                tasks[taskIndex].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks[taskIndex]);
            } else if (normalizedInput.startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(input.substring(7)) - 1;
                tasks[taskIndex].markAsNotDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks[taskIndex]);
            } else {
                tasks[taskCount] = new Task(input);
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
