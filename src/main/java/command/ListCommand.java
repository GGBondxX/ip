package command;

import task.Task;

import java.util.ArrayList;

/**
 * Represents a command to display all tasks currently in the task list.
 * This command iterates through the list and prints each task with its corresponding index.
 */
public class ListCommand extends Command{

    /**
     * Executes the list command by printing every task in the provided ArrayList.
     * Tasks are displayed in a numbered format starting from 1 for user readability.
     * @param list The ArrayList of Tasks to be displayed to the user.
     */
    @Override
    public void execute(ArrayList<Task> list) {
        int displayInputCount = 1;
        System.out.println("----------------------------------------------------");
        for (Task task : list) {
            System.out.printf("%d.%s\n", displayInputCount, task.toString());
            displayInputCount++;
        }
        System.out.println("----------------------------------------------------");
    }
}
