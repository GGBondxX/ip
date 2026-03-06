package command;

import exceptions.InvalidCommandException;
import task.Task;

import java.util.ArrayList;

/**
 * Represents an executable command within the GGBond application.
 * This abstract class serves as the base for all specific command types like Add, Delete, and Clear.
 */
public abstract class Command {
    protected boolean isExit = false;

    public Command() {

    }

    /**
     * Executes the specific logic associated with the command.
     * @param list The ArrayList of Tasks to be operated on.
     * @throws InvalidCommandException If the command execution fails due to invalid user input or state.
     */
    public abstract void execute(ArrayList<Task> list) throws InvalidCommandException;

    /**
     * Prints a confirmation message to the user after a task has been successfully added.
     * @param list The current list of tasks to show the updated count.
     * @param T The Task object that was recently added.
     */
    protected void printAddMessage(ArrayList<Task> list, Task T) {
        System.out.println("----------------------------------------------------");
        System.out.println("Got it. I've added this task:");
        System.out.printf("%s\n", T.getDescription());
        System.out.printf("Now you have %d tasks in the list\n", list.size());
        System.out.println("----------------------------------------------------");
    }

    /**
     * Returns whether this command should terminate the application loop.
     * @return true if the application should exit, false otherwise.
     */
    public boolean isExit() {
        return isExit;
    }

}