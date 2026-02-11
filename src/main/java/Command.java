import task.Task;

public abstract class Command {
    protected boolean isExit = false;

    public Command() {

    }

    public abstract int execute(Task[] list, int inputCounter);

    protected void printAddMessage(Task[] list, int inputCounter) {
        System.out.println("----------------------------------------------------");
        System.out.println("Got it. I've added this task:");
        System.out.printf("%s\n", list[inputCounter].toString());
        System.out.printf("Now you have %d tasks in the list\n", inputCounter+1);
        System.out.println("----------------------------------------------------");
    }

    public boolean isExit() {
        return isExit;
    }

}