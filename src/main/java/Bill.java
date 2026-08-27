/**
 * Greets the user when the chatbot starts and then exits.
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
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
    }
}
