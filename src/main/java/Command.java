import task.Task;

public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(Task[] list, int inputCounter) throws InvalidCommandException;

    public boolean isExit() {
        return isExit;
    }
}