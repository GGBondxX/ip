package command;

import task.Task;
import task.Todo;

public class TodoCommand extends Command{

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public int execute(Task[] list, int inputCounter){
        list[inputCounter] = new Todo(this.description);
        printAddMessage(list, inputCounter);
        return ++inputCounter;
    }
}
