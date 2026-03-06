package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a specific deadline date.
 * A Deadlines task includes a description and a date by which the task must be completed.
 */
public class Deadlines extends Task{

    protected LocalDate by;
    protected String printDate;

    /**
     * Initializes a new Deadlines task with a description and a due date.
     * The date is automatically formatted into a user-friendly string (e.g., Oct 15 2026).
     * @param description The text describing the task.
     * @param by The LocalDate representing the deadline.
     */
    public Deadlines (String description, LocalDate by) {
        super(description);
        this.by = by;
        this.printDate = by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    /**
     * Returns a string representation of the deadline task, including its type and formatted date.
     * @return A formatted string such as "[D][ ] finish report (by: Mar 6 2026)".
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + printDate + ")";
    }

    /**
     * Formats the deadline task data for storage in a text file.
     * The format uses pipes to separate task type, status, description, and the raw ISO date.
     * @return A machine-readable string formatted as "D | status | description | yyyy-mm-dd".
     */
    @Override
    public String toFileFormat() {
        String line;
        line = "D | " + (isDone ? "1 | " : "0 | ") + description + " | " + by;
        return line;
    }

}
