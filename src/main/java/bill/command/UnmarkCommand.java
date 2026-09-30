package bill.command;

import bill.exception.BillException;
import bill.storage.Storage;
import bill.task.Task;
import bill.task.TaskList;
import bill.ui.Ui;

/**
 * Marks a numbered task as incomplete.
 */
public class UnmarkCommand extends Command {
    private final int taskNumber;

    /**
     * Creates an unmark command for the displayed task number.
     *
     * @param taskNumber One-based task number.
     */
    public UnmarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BillException {
        Task task = tasks.unmark(taskNumber);
        storage.saveTasks(tasks.getTasks());
        ui.showUnmarked(task);
    }
}
