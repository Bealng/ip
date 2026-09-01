/**
 * Represents a task that takes place between a starting and ending time.
 */
public class Event extends Task {
    private final String from;
    private final String to;

    /**
     * Creates an incomplete event with its description and timing details.
     *
     * @param description Description of the event.
     * @param from Starting date or time as entered by the user.
     * @param to Ending date or time as entered by the user.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    protected String getTypeIcon() {
        return "E";
    }

    @Override
    protected String getDetails() {
        return " (from: " + from + " to: " + to + ")";
    }
}
