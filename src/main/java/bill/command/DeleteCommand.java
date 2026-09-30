package bill.command;

import bill.exception.BillException;
import bill.storage.Storage;
import bill.task.Task;
import bill.task.TaskList;
import bill.ui.Ui;

/**
 * Removes a numbered task from the list.
 */
public class DeleteCommand extends Command {
    private final int taskNumber;

    /**
     * Creates a delete command for the displayed task number.
     *
     * @param taskNumber One-based task number.
     */
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BillException {
        Task removedTask = tasks.delete(taskNumber);
        storage.saveTasks(tasks.getTasks());
        ui.showDeleted(removedTask, tasks.size());
    }
}
