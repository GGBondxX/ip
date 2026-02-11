import exceptions.InvalidCommandException;
import command.Command;
import parser.Parser;
import task.Task;

import java.util.Scanner;

public class GGBond {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task[] list = new Task[100];
        int inputCounter = 0;
        String line;

        printMessage("Hello! I'm GGBond.\n" + " What can I do for you?");

        Command command = null;
        boolean isExit = false;

        while(!isExit) {
            try {
                line = in.nextLine();
                Parser parser = new Parser(line);
                command = parser.callCommand();
                inputCounter = command.execute(list, inputCounter);
                isExit = command.isExit();
            } catch(InvalidCommandException e) {
                System.out.println("----------------------------------------------------");
                System.out.println(e.getMessage());
                System.out.println("----------------------------------------------------");
            }
        }
        printMessage("Bye. Hope to see you again soon!");

    }

    private static void printMessage(String x) {
        System.out.println("----------------------------------------------------");
        System.out.println(x);
        System.out.println("----------------------------------------------------");
    }
}
