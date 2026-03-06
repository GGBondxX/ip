package task;

/**
 * Represents a task that occurs within a specific time range.
 * An Events task includes a description, a start time, and an end time.
 */
public class Events extends Task{

    protected String from;
    protected String to;

    /**
     * Initializes a new Events task with a description and a time duration.
     * @param description The text describing the event.
     * @param from The starting time or date of the event.
     * @param to The ending time or date of the event.
     */
    public Events(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the event task, including its type and time range.
     * @return A formatted string such as "[E][ ] project meeting (from: Mon 2pm to: 4pm)".
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Formats the event task data for storage in a text file.
     * The start and end times are concatenated with a hyphen for compact storage.
     * @return A machine-readable string formatted as "E | status | description | from-to".
     */
    @Override
    public String toFileFormat() {
        String line;
        line = "E | " + (isDone ? "1 | " : "0 | ") + description + " | " + from + "-" + to;
        return line;
    }
}
