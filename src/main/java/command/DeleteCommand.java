package command;

import task.Task;

import java.util.ArrayList;

/**
 * Represents a command to delete a specific task from the task list.
 * This command identifies the task to be removed using its index in the list.
 */
public class DeleteCommand extends Command{

    private int targetIndex;

    /**
     * Creates a new DeleteCommand with the specified index of the task to be removed.
     * @param index The zero-based index of the task in the ArrayList.
     */
    public DeleteCommand(int index) {
        this.targetIndex = index;
    }

    /**
     * Executes the command by removing the task at the target index from the list.
     * It displays a confirmation message showing the removed task and the updated task count.
     * @param list The ArrayList of Tasks from which the task will be deleted.
     */
    @Override
    public void execute(ArrayList<Task> list) {
        System.out.println("----------------------------------------------------");
        System.out.println("Noted. I've removed this task:");
        System.out.printf("%s\n", list.get(targetIndex).toString());
        System.out.printf("Now you have %d tasks in the list.\n", list.size()-1);
        System.out.println("----------------------------------------------------");
        list.remove(targetIndex);
    }
}
