import task.Events;
import task.Task;

public class EventCommand extends Command{

    private String description;
    private String from;
    private String to;

    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public int execute(Task[] list, int inputCounter) {
        list[inputCounter] = new Events(description, from, to);
        printAddMessage(list, inputCounter);
        return ++inputCounter;
    }
}
