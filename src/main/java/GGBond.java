import exceptions.InvalidCommandException;
import command.Command;
import parser.Parser;
import storage.Storage;
import task.Task;
import ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class GGBond {
    private Storage storage;
    private ArrayList<Task> list;
    private Ui ui;

    public GGBond() {
        ui = new Ui();
        storage = new Storage();
        try {
            list = storage.load();
        } catch (IOException e) {
            ui.showError("Could not read data file: " + e.getMessage());
            list = new ArrayList<>();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Parser parser = new Parser(fullCommand);
                Command command = parser.callCommand();
                command.execute(list); // Pass ui.Ui to commands if they need to print
                isExit = command.isExit();
            } catch (InvalidCommandException e) {
                ui.showError(e.getMessage());
            }
        }

        try {
            storage.save(list);
        } catch (IOException e) {
            ui.showError("Failed to save data: " + e.getMessage());
        }
        ui.printMessage("Bye. Hope to see you again soon!");
    }
    //test
    public static void main(String[] args) {
        new GGBond().run();
    }
}
