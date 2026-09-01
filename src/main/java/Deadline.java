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
        super(description);
        this.by = by;
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
