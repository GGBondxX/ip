package command;

import task.Task;

public class MarkCommand extends Command{

    private int targetIndex;

    public MarkCommand(int index) {
        this.targetIndex = index;
    }

    @Override
    public int execute(Task[] list, int inputCounter) {
        list[targetIndex].setToDone();
        System.out.println("----------------------------------------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.printf("%s\n", list[targetIndex].toString());
        System.out.println("----------------------------------------------------");
        return inputCounter;
    }
}
