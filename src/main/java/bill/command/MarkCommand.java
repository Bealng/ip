package bill.command;

import bill.exception.BillException;
import bill.storage.Storage;
import bill.task.Task;
import bill.task.TaskList;
import bill.ui.Ui;

/**
 * Marks a numbered task as completed.
 */
public class MarkCommand extends Command {
    private final int taskNumber;

    /**
     * Creates a mark command for the displayed task number.
     *
     * @param taskNumber One-based task number.
     */
    public MarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BillException {
        Task task = tasks.mark(taskNumber);
        storage.saveTasks(tasks.getTasks());
        ui.showMarked(task);
    }
}
