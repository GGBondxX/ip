package command;

import exceptions.InvalidCommandException;
import task.Task;

import java.util.ArrayList;

/**
 * Represents a command to mark a specific task in the list as completed.
 * This command updates the status of the task at the specified index.
 */
public class MarkCommand extends Command{

    private int targetIndex;

    /**
     * Creates a new MarkCommand with the specified index of the task to be marked as done.
     * @param index The zero-based index of the task in the ArrayList.
     */
    public MarkCommand(int index) {
        this.targetIndex = index;
    }

    /**
     * Executes the command by setting the status of the target task to done.
     * It validates that the index is within the list boundaries before proceeding.
     * @param list The ArrayList of Tasks containing the task to be marked.
     * @throws InvalidCommandException If the provided index is out of the list's range.
     */
    @Override
    public void execute(ArrayList<Task> list) throws InvalidCommandException{
        if(targetIndex < 0 || targetIndex >= list.size()) {
            throw new InvalidCommandException("seems like there is no such task in our current list");
        }
        Task task = list.get(targetIndex);
        task.setToDone();
        System.out.println("----------------------------------------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.printf("%s\n", task.toString());
        System.out.println("----------------------------------------------------");
    }
}
