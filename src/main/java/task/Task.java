package task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void setToDone() {
        this.isDone = true;
    }

    public void setToUndone() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String getDescription() {
        return this.description;
    }

    public String toFileFormat() {
        return null;
    }
}
