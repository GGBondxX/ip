package command;

import task.Task;

import java.util.ArrayList;

public abstract class Command {
    protected boolean isExit = false;

    public Command() {

    }

    public abstract void execute(ArrayList<Task> list);

    protected void printAddMessage(ArrayList<Task> list, Task T) {
        System.out.println("----------------------------------------------------");
        System.out.println("Got it. I've added this task:");
        System.out.printf("%s\n", T.getDescription());
        System.out.printf("Now you have %d tasks in the list\n", list.size());
        System.out.println("----------------------------------------------------");
    }

    public boolean isExit() {
        return isExit;
    }

}