import task.Deadlines;
import task.Task;

public class DeadlineCommand extends Command{

    private String description;
    private String by;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public int execute(Task[] list, int inputCounter) {
        list[inputCounter] = new Deadlines(this.description, this.by);
        printAddMessage(list, inputCounter);
        return ++inputCounter;
    }
}
