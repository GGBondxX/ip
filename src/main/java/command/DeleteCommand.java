package command;

import task.Task;

import java.util.ArrayList;

public class DeleteCommand extends Command{

    private int targetIndex;

    public DeleteCommand(int index) {
        this.targetIndex = index;
    }

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
