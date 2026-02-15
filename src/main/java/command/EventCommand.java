package command;

import task.Events;
import task.Task;

import java.util.ArrayList;

public class EventCommand extends Command{

    private String description;
    private String from;
    private String to;

    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(ArrayList<Task> list) {
        Task task = new Events(description, from, to);
        list.add(task);
        printAddMessage(list, task);
    }
}
