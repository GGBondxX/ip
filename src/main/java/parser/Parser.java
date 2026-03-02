package parser;

import command.*;
import exceptions.InvalidCommandException;

public class Parser {

    String[] words;

    public Parser(String line) {
        words = line.split(" ");
    }

    public Command callCommand() throws InvalidCommandException {
        this.words[0] = this.words[0].toLowerCase();
        int taskNumber = 0;
        String description = "";
        String by = "";
        String from = "";
        String to = "";
        String currentSection = "desc";

        for (int i = 1; i < words.length; i++) {
            if(words[i].equals("/by")) {
                currentSection = "by";
            }
            else if (words[i].equals("/from")) {
                currentSection = "from";
            }
            else if (words[i].equals("/to")) {
                currentSection = "to";
            }
            else {
                switch (currentSection) {
                case "desc":
                    description += (description.isEmpty() ? "" : " ") + words[i];
                    break;
                case "by":
                    by += (by.isEmpty() ? "" : " ") + words[i];
                    break;
                case "from":
                    from += (from.isEmpty() ? "" : " ") + words[i];
                    break;
                case "to":
                    to += (to.isEmpty() ? "" : " ") + words[i];
                    break;
                }
            }
        }

        switch (this.words[0]) {
        case "todo":
            return new TodoCommand(description);
        case "deadline":
            return new DeadlineCommand(description, by);
        case "event":
            return new EventCommand(description, from, to);
        case "mark":
            try {
                taskNumber = Integer.parseInt(this.words[1]) - 1;
                return new MarkCommand(taskNumber);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("mark command needs a valid task number (e.g., mark 1)");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new InvalidCommandException("mark command needs a task number (e.g., mark 1)");
            }
        case "unmark":
            try {
                taskNumber = Integer.parseInt(this.words[1]) - 1;
                return new UnmarkCommand(taskNumber);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("unmark command needs a valid task number (e.g., unmark 1)");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new InvalidCommandException("unmark command needs a task number (e.g., unmark 1)");
            }
        case "delete":
            try {
                taskNumber = Integer.parseInt(this.words[1]) - 1;
                return new DeleteCommand(taskNumber);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("delete command needs a valid task number (e.g., delete 1)");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new InvalidCommandException("delete command needs a task number (e.g., delete 1)");
            }
        case "list":
            return new ListCommand();
        case "clear":
            return new ClearCommand();
        case "bye":
            return new ExitCommand();
        default:
            throw new InvalidCommandException("oh no you did not enter a correct command");
        }
    }
}
