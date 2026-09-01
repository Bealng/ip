/**
 * Converts task-related user input into the corresponding task type.
 */
public final class Parser {
    private static final String TODO_PREFIX = "todo ";
    private static final String DEADLINE_PREFIX = "deadline ";
    private static final String EVENT_PREFIX = "event ";
    private static final String DEADLINE_SEPARATOR = " /by ";
    private static final String EVENT_FROM_SEPARATOR = " /from ";
    private static final String EVENT_TO_SEPARATOR = " /to ";

    private Parser() {
    }

    /**
     * Converts user input into a todo, deadline, or event.
     * Plain text is treated as a todo to preserve Bill's original add command.
     *
     * @param userInput Task command entered by the user.
     * @return Task represented by the command.
     */
    public static Task parseTask(String userInput) {
        String normalizedInput = userInput.toLowerCase();
        if (normalizedInput.startsWith(TODO_PREFIX)) {
            return parseTodo(userInput);
        } else if (normalizedInput.startsWith(DEADLINE_PREFIX)) {
            return parseDeadline(userInput);
        } else if (normalizedInput.startsWith(EVENT_PREFIX)) {
            return parseEvent(userInput);
        }
        return new Todo(userInput);
    }

    private static Todo parseTodo(String userInput) {
        String description = userInput.substring(TODO_PREFIX.length());
        return new Todo(description);
    }

    private static Deadline parseDeadline(String userInput) {
        String deadlineDetails = userInput.substring(DEADLINE_PREFIX.length());
        int separatorIndex = deadlineDetails.toLowerCase().indexOf(DEADLINE_SEPARATOR);
        String description = deadlineDetails.substring(0, separatorIndex);
        String by = deadlineDetails.substring(separatorIndex + DEADLINE_SEPARATOR.length());
        return new Deadline(description, by);
    }

    private static Event parseEvent(String userInput) {
        String eventDetails = userInput.substring(EVENT_PREFIX.length());
        String normalizedDetails = eventDetails.toLowerCase();
        int fromIndex = normalizedDetails.indexOf(EVENT_FROM_SEPARATOR);
        int toIndex = normalizedDetails.indexOf(EVENT_TO_SEPARATOR,
                fromIndex + EVENT_FROM_SEPARATOR.length());
        String description = eventDetails.substring(0, fromIndex);
        String from = eventDetails.substring(fromIndex + EVENT_FROM_SEPARATOR.length(), toIndex);
        String to = eventDetails.substring(toIndex + EVENT_TO_SEPARATOR.length());
        return new Event(description, from, to);
    }
}
