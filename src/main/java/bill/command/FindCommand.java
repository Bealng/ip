package bill.command;

import bill.storage.Storage;
import bill.task.TaskList;
import bill.ui.Ui;

/**
 * Finds tasks whose descriptions contain the requested text.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Creates a description search command.
     *
     * @param keyword Text to look for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFound(tasks.find(keyword), keyword);
    }
}
