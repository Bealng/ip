package bill.command;

import bill.storage.Storage;
import bill.task.TaskList;
import bill.ui.Ui;

/**
 * Signals that Bill should stop accepting commands.
 */
public class ExitCommand extends Command {
    /**
     * Creates a command that ends the conversation.
     */
    public ExitCommand() {
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        // Bill prints the farewell after the command loop ends.
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
