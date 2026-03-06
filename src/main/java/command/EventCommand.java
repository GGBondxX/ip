package command;

import task.Events;
import task.Task;

import java.util.ArrayList;

/**
 * Represents a command to add an event task to the task list.
 * An event task includes a description and a specific time range (start and end).
 */
public class EventCommand extends Command{

    private String description;
    private String from;
    private String to;

    /**
     * Creates a new EventCommand with a description and a specified time duration.
     * @param description The description of the event.
     * @param from The starting time or date of the event.
     * @param to The ending time or date of the event.
     */
    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes the command by creating a new Events task and adding it to the list.
     * After successfully adding the task, it triggers a confirmation message to the user.
     * @param list The ArrayList of Tasks where the new event will be stored.
     */
    @Override
    public void execute(ArrayList<Task> list) {
        Task task = new Events(description, from, to);
        list.add(task);
        printAddMessage(list, task);
    }
}
