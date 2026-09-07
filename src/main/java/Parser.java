import java.util.Locale;

/**
 * Converts task-related user input into the corresponding task type.
 */
public final class Parser {
    private static final String TODO_COMMAND = "todo";
    private static final String DEADLINE_COMMAND = "deadline";
    private static final String EVENT_COMMAND = "event";
    private static final String TODO_PREFIX = TODO_COMMAND + " ";
    private static final String DEADLINE_PREFIX = DEADLINE_COMMAND + " ";
    private static final String EVENT_PREFIX = EVENT_COMMAND + " ";
    private static final String DEADLINE_SEPARATOR = "/by";
    private static final String EVENT_FROM_SEPARATOR = "/from";
    private static final String EVENT_TO_SEPARATOR = "/to";

    private Parser() {
    }

    /**
     * Converts user input into a todo, deadline, or event.
     * @param userInput Task command entered by the user.
     * @return Task represented by the command.
     * @throws BillException If the command is unknown or its details are incomplete.
     */
    public static Task parseTask(String userInput) throws BillException {
        String trimmedInput = userInput.strip();
        String normalizedInput = trimmedInput.toLowerCase(Locale.ROOT);
        if (isCommand(normalizedInput, TODO_COMMAND, TODO_PREFIX)) {
            return parseTodo(trimmedInput);
        } else if (isCommand(normalizedInput, DEADLINE_COMMAND, DEADLINE_PREFIX)) {
            return parseDeadline(trimmedInput);
        } else if (isCommand(normalizedInput, EVENT_COMMAND, EVENT_PREFIX)) {
            return parseEvent(trimmedInput);
        }
        if (normalizedInput.isEmpty()) {
            throw new BillException("Please enter a command. Type 'help' to see what I understand.");
        }
        throw new BillException("I don't recognise that command. Type 'help' to see what I understand.");
    }

    private static boolean isCommand(String input, String command, String commandPrefix) {
        return input.equals(command) || input.startsWith(commandPrefix);
    }

    private static Todo parseTodo(String userInput) throws BillException {
        String description = userInput.substring(TODO_COMMAND.length()).strip();
        if (description.isEmpty()) {
            throw new BillException("A todo needs a description. Try: todo read a book");
        }
        return new Todo(description);
    }

    private static Deadline parseDeadline(String userInput) throws BillException {
        String deadlineDetails = userInput.substring(DEADLINE_COMMAND.length()).strip();
        String normalizedDetails = deadlineDetails.toLowerCase(Locale.ROOT);
        int separatorIndex = normalizedDetails.indexOf(DEADLINE_SEPARATOR);
        if (separatorIndex < 0) {
            throw new BillException("A deadline needs '/by'. Try: deadline submit report /by Friday");
        }
        String description = deadlineDetails.substring(0, separatorIndex).strip();
        String by = deadlineDetails.substring(separatorIndex + DEADLINE_SEPARATOR.length()).strip();
        if (description.isEmpty()) {
            throw new BillException("A deadline needs a description before '/by'.");
        }
        if (by.isEmpty()) {
            throw new BillException("A deadline needs a date or time after '/by'.");
        }
        return new Deadline(description, by);
    }

    private static Event parseEvent(String userInput) throws BillException {
        String eventDetails = userInput.substring(EVENT_COMMAND.length()).strip();
        String normalizedDetails = eventDetails.toLowerCase(Locale.ROOT);
        int fromIndex = normalizedDetails.indexOf(EVENT_FROM_SEPARATOR);
        if (fromIndex < 0) {
            throw new BillException("An event needs '/from'. Try: event lecture /from 4pm /to 6pm");
        }
        int toIndex = normalizedDetails.indexOf(EVENT_TO_SEPARATOR,
                fromIndex + EVENT_FROM_SEPARATOR.length());
        if (toIndex < 0) {
            throw new BillException("An event needs '/to' after its starting time.");
        }
        String description = eventDetails.substring(0, fromIndex).strip();
        String from = eventDetails.substring(fromIndex + EVENT_FROM_SEPARATOR.length(), toIndex).strip();
        String to = eventDetails.substring(toIndex + EVENT_TO_SEPARATOR.length()).strip();
        if (description.isEmpty()) {
            throw new BillException("An event needs a description before '/from'.");
        }
        if (from.isEmpty()) {
            throw new BillException("An event needs a starting time after '/from'.");
        }
        if (to.isEmpty()) {
            throw new BillException("An event needs an ending time after '/to'.");
        }
        return new Event(description, from, to);
    }
}
