package bill.command;

import bill.storage.Storage;
import bill.task.TaskList;
import bill.ui.Ui;

/**
 * Displays the guide to supported commands.
 */
public class HelpCommand extends Command {
    /**
     * Creates a command that displays the help guide.
     */
    public HelpCommand() {
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showHelp();
    }
}
