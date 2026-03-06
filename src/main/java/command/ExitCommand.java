package command;

import task.Task;

import java.util.ArrayList;

/**
 * Represents a command to terminate the application.
 * This command sets the exit flag to true, signaling the main loop to stop.
 */
public class ExitCommand extends Command{

    /**
     * Executes the exit command by updating the isExit status.
     * When called, the application loop in the main class will recognize the change and stop execution.
     * @param list The ArrayList of Tasks (unused by this specific command).
     */
    @Override
    public void execute(ArrayList<Task> list) {
        this.isExit = true;
    }
}
