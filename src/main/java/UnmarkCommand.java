import task.Task;

public class UnmarkCommand extends Command{

    private int targetIndex;

    public UnmarkCommand(int index) {
        this.targetIndex = index;
    }

    @Override
    public int execute(Task[] list, int inputCounter) {
        list[targetIndex].setToUndone();
        System.out.println("----------------------------------------------------");
        System.out.println("Nice! I've marked this task as not done yet:");
        System.out.printf("%s\n", list[targetIndex].toString());
        System.out.println("----------------------------------------------------");
        return inputCounter;
    }
}
