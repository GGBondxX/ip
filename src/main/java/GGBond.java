import exceptions.InvalidCommandException;
import command.Command;
import parser.Parser;
import task.Task;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GGBond {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Storage storage = new Storage();
        ArrayList<Task> list;
        try {
            list = storage.load();
        } catch (IOException e) {
            System.out.println("Could not read data file: " + e.getMessage());
            list = new ArrayList<>();
        }

        String line;

        printMessage("Hello! I'm GGBond.\n" + " What can I do for you?");

        Command command = null;
        boolean isExit = false;

        while(!isExit) {
            try {
                line = in.nextLine();
                Parser parser = new Parser(line);
                command = parser.callCommand();
                command.execute(list);
                isExit = command.isExit();
            } catch(InvalidCommandException e) {
                System.out.println("----------------------------------------------------");
                System.out.println(e.getMessage());
                System.out.println("----------------------------------------------------");
            }
        }
        try {
            storage.save(list);
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
        printMessage("Bye. Hope to see you again soon!");

    }

    private static void printMessage(String x) {
        System.out.println("----------------------------------------------------");
        System.out.println(x);
        System.out.println("----------------------------------------------------");
    }
}
