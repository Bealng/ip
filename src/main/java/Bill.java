import java.util.Scanner;

/**
 * Greets the user and manages tasks until the user enters "bye".
 */
public class Bill {
    private static final int MAX_TASKS = 100;
    private static final String HORIZONTAL_LINE = "____________________________________________________________";
    private static final String BANNER = " ____  _ _ _ \n"
            + "| __ )(_) | |\n"
            + "|  _ \\| | | |\n"
            + "| |_) | | | |\n"
            + "|____/|_|_|_|\n";

    /**
     * Starts Bill and processes user commands until the user exits.
     *
     * @param args Command-line arguments; not used by this application.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Task[] tasks = new Task[MAX_TASKS];
            int taskCount = 0;

            printWelcome();
            String userInput = scanner.nextLine();
            while (!userInput.equalsIgnoreCase("bye")) {
                taskCount = processInput(userInput, tasks, taskCount);
                System.out.println(HORIZONTAL_LINE);
                userInput = scanner.nextLine();
            }
            printGoodbye();
        }
    }

    /**
     * Processes one user input and returns the resulting number of tasks.
     *
     * @param userInput User input to process.
     * @param tasks Tasks currently stored by Bill.
     * @param taskCount Number of tasks currently stored.
     * @return Number of tasks after processing the input.
     */
    private static int processInput(String userInput, Task[] tasks, int taskCount) {
        String normalizedInput = userInput.toLowerCase();

        if (normalizedInput.equals("list")) {
            printTasks(tasks, taskCount);
        } else if (normalizedInput.equals("help")) {
            printHelp();
        } else if (normalizedInput.equals("stats")) {
            printStats(tasks, taskCount);
        } else if (normalizedInput.startsWith("mark ")) {
            markTask(userInput, tasks);
        } else if (normalizedInput.startsWith("unmark ")) {
            unmarkTask(userInput, tasks);
        } else {
            Task task = Parser.parseTask(userInput);
            return addTask(task, tasks, taskCount);
        }

        return taskCount;
    }

    /**
     * Prints all stored tasks with their numbers and completion states.
     */
    private static void printTasks(Task[] tasks, int taskCount) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
        }
    }

    /**
     * Prints a guide to Bill's supported commands.
     */
    private static void printHelp() {
        System.out.println("Here are the commands I understand:");
        System.out.println("  list          - show every task");
        System.out.println("  mark NUMBER   - mark a task as done");
        System.out.println("  unmark NUMBER - mark a task as not done");
        System.out.println("  todo TASK     - add a task without a date or time");
        System.out.println("  deadline TASK /by TIME - add a task with a deadline");
        System.out.println("  event TASK /from START /to END - add an event");
        System.out.println("  stats         - show your progress");
        System.out.println("  bye           - exit Bill");
        System.out.println("  Any other text adds a todo.");
    }

    /**
     * Prints the total, completed, and remaining task counts.
     */
    private static void printStats(Task[] tasks, int taskCount) {
        int completedCount = countCompletedTasks(tasks, taskCount);
        int remainingCount = taskCount - completedCount;
        System.out.println("Task stats: " + taskCount + " total, "
                + completedCount + " done, " + remainingCount + " remaining.");
    }

    /**
     * Returns the number of completed tasks.
     */
    private static int countCompletedTasks(Task[] tasks, int taskCount) {
        int completedCount = 0;
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].isDone()) {
                completedCount++;
            }
        }
        return completedCount;
    }

    /**
     * Marks the task selected by a mark command as completed.
     */
    private static void markTask(String userInput, Task[] tasks) {
        int taskIndex = parseTaskIndex(userInput, "mark ");
        tasks[taskIndex].markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + tasks[taskIndex]);
    }

    /**
     * Marks the task selected by an unmark command as incomplete.
     */
    private static void unmarkTask(String userInput, Task[] tasks) {
        int taskIndex = parseTaskIndex(userInput, "unmark ");
        tasks[taskIndex].markAsNotDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + tasks[taskIndex]);
    }

    /**
     * Returns the zero-based task index specified by a command.
     */
    private static int parseTaskIndex(String userInput, String commandPrefix) {
        return Integer.parseInt(userInput.substring(commandPrefix.length())) - 1;
    }

    /**
     * Stores and displays a newly created task.
     */
    private static int addTask(Task task, Task[] tasks, int taskCount) {
        tasks[taskCount] = task;
        int updatedTaskCount = taskCount + 1;
        String taskLabel = updatedTaskCount == 1 ? "task" : "tasks";
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + updatedTaskCount + " " + taskLabel + " in the list.");
        return updatedTaskCount;
    }

    /**
     * Prints Bill's banner and greeting.
     */
    private static void printWelcome() {
        System.out.println(HORIZONTAL_LINE);
        System.out.print(BANNER);
        System.out.println("Hello! I'm Bill.");
        System.out.println("What can I do for you?");
        System.out.println("Type 'help' if you'd like a tour of my commands.");
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Prints Bill's farewell.
     */
    private static void printGoodbye() {
        System.out.println("Bye. Have a good day mate!");
        System.out.println(HORIZONTAL_LINE);
    }
}
