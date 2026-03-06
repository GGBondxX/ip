package command;

import task.Task;

import java.util.ArrayList;

/**
 * Represents a command to mark a specific task in the list as not completed.
 * This command reverts the status of a previously completed task to undone.
 */
public class UnmarkCommand extends Command{

    private int targetIndex;

    /**
     * Creates a new UnmarkCommand with the specified index of the task to be unmarked.
     * @param index The zero-based index of the task in the ArrayList.
     */
    public UnmarkCommand(int index) {
        this.targetIndex = index;
    }

    /**
     * Executes the command by setting the status of the target task to undone.
     * It displays a confirmation message to the user showing the updated status of the task.
     * @param list The ArrayList of Tasks containing the task to be unmarked.
     */
    @Override
    public void execute(ArrayList<Task> list) {
        Task task = list.get(targetIndex);
        task.setToUndone();
        System.out.println("----------------------------------------------------");
        System.out.println("Nice! I've marked this task as not done yet:");
        System.out.printf("%s\n", task.toString());
        System.out.println("----------------------------------------------------");
    }
}
