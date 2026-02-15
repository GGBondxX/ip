package command;

import task.Task;

import java.util.ArrayList;

public class UnmarkCommand extends Command{

    private int targetIndex;

    public UnmarkCommand(int index) {
        this.targetIndex = index;
    }

    @Override
    public void execute(ArrayList<Task> list) {
        Task task = list.get(targetIndex);
        task.setToUndone();
        System.out.println("----------------------------------------------------");
        System.out.println("Nice! I've marked this task as not done yet:");
        System.out.printf("%s\n", task.toString());
        System.out.println("----------------------------------------------------");
    }
}
