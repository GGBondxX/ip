package command;

import task.Deadlines;
import task.Task;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a command to add a deadline task to the task list.
 * This command encapsulates the task description and the deadline date.
 */
public class DeadlineCommand extends Command{

    private String description;
    private LocalDate by;

    /**
     * Creates a new DeadlineCommand with the specified description and date.
     * @param description The description of the deadline task.
     * @param by The date by which the task must be completed.
     */
    public DeadlineCommand(String description, LocalDate by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the command by creating a new Deadlines task and adding it to the list.
     * After adding the task, it displays a confirmation message to the user.
     * @param list The ArrayList of Tasks where the new deadline will be stored.
     */
    @Override
    public void execute(ArrayList<Task> list) {
        Task task = new Deadlines(this.description, this.by);
        list.add(task);
        printAddMessage(list, task);
    }
}
