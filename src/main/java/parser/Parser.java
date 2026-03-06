package parser;

import command.*;
import exceptions.InvalidCommandException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Deciphers user input strings and transforms them into executable Command objects.
 * This class handles the extraction of task descriptions, dates, and keywords from the input line.
 */
public class Parser {

    String[] words;

    /**
     * Initializes a new Parser by splitting the raw input line into an array of words.
     * @param line The raw user input string from the command line interface.
     */
    public Parser(String line) {
        words = line.split(" ");
    }

    /**
     * Identifies the command type and creates the corresponding Command object.
     * It parses flags such as /by, /from, and /to to isolate task parameters.
     * @return A Command object representing the user's intended action.
     * @throws InvalidCommandException If the input format is incorrect, dates are unparseable, or the command is unknown.
     */
    public Command callCommand() throws InvalidCommandException {
        this.words[0] = this.words[0].toLowerCase();
        int taskNumber = 0;
        String description = "";
        String by = "";
        String from = "";
        String to = "";
        String keyword = "";
        String currentSection = "desc";

        if(this.words[0].equals("find")) {
            currentSection = "keyword";
        }

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
                case "keyword":
                    keyword += (keyword.isEmpty() ? "" : " ") + words[i];
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
            LocalDate deadlineTime;
            try {
                deadlineTime = LocalDate.parse(by.trim());
            } catch (DateTimeParseException e) {
                throw new InvalidCommandException("enter deadline date in the format of yyyy-mm-dd");
            }
            return new DeadlineCommand(description, deadlineTime);
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
        case "find":
            return new FindCommand(keyword);
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
