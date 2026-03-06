package task;

/**
 * Represents a generic task in the GGBond application.
 * This class serves as the base for specialized task types such as Todo, Deadlines, and Events.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Initializes a new Task with a description.
     * By default, a new task is marked as not completed.
     * @param description The text describing the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Updates the task status to completed.
     */
    public void setToDone() {
        this.isDone = true;
    }

    /**
     * Reverts the task status to not completed.
     */
    public void setToUndone() {
        this.isDone = false;
    }

    /**
     * Returns a status icon representing the task's completion state.
     * @return "X" if the task is done, or a space " " if it is not done.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Returns a string representation of the task, including its status icon and description.
     * @return A formatted string such as "[X] read book".
     */
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * Retrieves the description of the task.
     * @return The task description string.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns a machine-readable string format for file storage.
     * This method is intended to be overridden by subclasses.
     * @return A string formatted for storage, or null if not implemented.
     */
    public String toFileFormat() {
        return null;
    }
}
