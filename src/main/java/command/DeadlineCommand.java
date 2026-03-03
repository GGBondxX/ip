package command;

import task.Deadlines;
import task.Task;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeadlineCommand extends Command{

    private String description;
    private LocalDate by;

    public DeadlineCommand(String description, LocalDate by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(ArrayList<Task> list) {
        Task task = new Deadlines(this.description, this.by);
        list.add(task);
        printAddMessage(list, task);
    }
}
