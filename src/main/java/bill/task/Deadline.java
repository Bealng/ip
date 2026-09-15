package bill.task;

/**
 * Represents a task that should be completed by a specified time.
 */
public class Deadline extends Task {
    private final String by;

    /**
     * Creates an incomplete deadline with its description and due time.
     *
     * @param description Description of the deadline.
     * @param by Due date or time as entered by the user.
     */
    public Deadline(String description, String by) {
        this(description, by, false);
    }

    /**
     * Creates a deadline with its description, due time, and completion state.
     *
     * @param description Description of the deadline.
     * @param by Due date or time as entered by the user.
     * @param isDone Whether the deadline is completed.
     */
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Returns the deadline's due date or time.
     *
     * @return Due date or time as entered by the user.
     */
    public String getBy() {
        return by;
    }

    @Override
    protected String getTypeIcon() {
        return "D";
    }

    @Override
    protected String getDetails() {
        return " (by: " + by + ")";
    }
}
