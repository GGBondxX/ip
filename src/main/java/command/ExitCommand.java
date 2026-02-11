package command;

import task.Task;

public class ExitCommand extends Command{


    @Override
    public int execute(Task[] list, int inputCounter) {
        this.isExit = true;
        return 0;
    }
}
