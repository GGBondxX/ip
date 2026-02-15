package command;

import task.Task;

import java.util.ArrayList;

public class ListCommand extends Command{


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
