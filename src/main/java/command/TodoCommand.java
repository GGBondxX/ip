package command;

import task.Task;
import task.Todo;

import java.util.ArrayList;

/**
 * Represents a command to add a simple todo task to the task list.
 * A todo task consists only of a description without any date or time constraints.
 */
public class TodoCommand extends Command{

    private String description;

    /**
     * Creates a new TodoCommand with the specified task description.
     * @param description The text describing the task to be added.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by creating a new Todo task and adding it to the list.
     * After adding the task, it displays a confirmation message to the user.
     * @param list The ArrayList of Tasks where the new todo will be stored.
     */
    @Override
    public void execute(ArrayList<Task> list){
        Task task = new Todo(this.description);
        list.add(task);
        printAddMessage(list, task);
    }
}
