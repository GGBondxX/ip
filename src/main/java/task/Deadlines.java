package task;

public class Deadlines extends Task{

    protected String by;

    public Deadlines (String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + by + ")";
    }

    @Override
    public String toFileFormat() {
        String line;
        line = "D | " + (isDone ? "1 | " : "0 | ") + description + " | " + by;
        return line;
    }

}
