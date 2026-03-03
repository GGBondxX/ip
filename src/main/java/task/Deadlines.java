package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task{

    protected LocalDate by;
    protected String printDate;

    public Deadlines (String description, LocalDate by) {
        super(description);
        this.by = by;
        this.printDate = by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }


    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + printDate + ")";
    }

    @Override
    public String toFileFormat() {
        String line;
        line = "D | " + (isDone ? "1 | " : "0 | ") + description + " | " + by;
        return line;
    }

}
