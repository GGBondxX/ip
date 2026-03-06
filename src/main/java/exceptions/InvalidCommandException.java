package exceptions;

/**
 * Represents an exception thrown when an unrecognized or malformed command is entered.
 * This class allows the GGBond application to handle user input errors gracefully without crashing.
 */
public class InvalidCommandException extends Exception{

    /**
     * Creates a new InvalidCommandException with a specific error message.
     * @param message The detailed error message explaining why the command was invalid.
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}
