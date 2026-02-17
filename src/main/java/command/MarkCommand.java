package command;

import exceptions.InvalidCommandException;
import task.Task;

import java.util.ArrayList;

public class MarkCommand extends Command{

    private int targetIndex;

    public MarkCommand(int index) {
        this.targetIndex = index;
    }

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
