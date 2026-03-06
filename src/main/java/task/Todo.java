package task;

/**
 * Represents a basic task without any specific date or time constraints.
 * A Todo task is the simplest form of task, containing only a description and a completion status.
 */
public class Todo  extends Task{

    /**
     * Initializes a new Todo task with the specified description.
     * @param description The text describing the task to be done.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the Todo task, including its type identifier.
     * @return A formatted string such as "[T][ ] read book".
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Formats the Todo task data for storage in a text file.
     * The format uses pipes to separate the task type, status, and description.
     * @return A machine-readable string formatted as "T | status | description".
     */
    @Override
    public String toFileFormat() {
        String line;
        line = "T | " + (isDone ? "1 | " : "0 | ") + description;
        return line;
    }
}
