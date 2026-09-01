/**
 * Represents a task and whether it has been completed.
 */
public class Task {
    private final String description;
    private boolean isDone;

    /**
     * Creates an incomplete task with the given description.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks this task as completed.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks this task as incomplete.
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Returns whether this task is completed.
     *
     * @return True if the task is completed.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns the letter used to identify this task's type.
     *
     * @return Task type icon.
     */
    protected String getTypeIcon() {
        return "T";
    }

    /**
     * Returns any timing information displayed after the task description.
     *
     * @return Additional display details.
     */
    protected String getDetails() {
        return "";
    }

    /**
     * Returns the task status and description for display.
     *
     * @return Display form of this task.
     */
    @Override
    public String toString() {
        String statusIcon = isDone ? "X" : " ";
        return "[" + getTypeIcon() + "][" + statusIcon + "] " + description + getDetails();
    }
}
