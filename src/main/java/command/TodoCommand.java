package command;

import task.Task;
import task.Todo;

import java.util.ArrayList;

public class TodoCommand extends Command{

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(ArrayList<Task> list){
        Task task = new Todo(this.description);
        list.add(task);
        printAddMessage(list, task);
    }
}
