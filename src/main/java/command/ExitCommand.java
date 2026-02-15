package command;

import task.Task;

import java.util.ArrayList;

public class ExitCommand extends Command{


    @Override
    public void execute(ArrayList<Task> list) {
        this.isExit = true;
    }
}
