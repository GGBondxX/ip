import task.Deadlines;
import task.Events;
import task.Task;
import task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Storage {
    private static final String FILE_PATH = "./data/GGBond.txt";
    private static final String DIRECTORY_PATH = "./data/";

    public Storage() {
        prepareFile();
    }

    private void prepareFile() {
        try {
            File folder = new File(DIRECTORY_PATH);
            if (!folder.exists()) {
                folder.mkdir(); // Creates folder if missing
            }

            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile(); // Creates file if missing
            }
        } catch (IOException e) {
            System.out.println("Error creating storage: " + e.getMessage());
        }
    }

    public void save(ArrayList<Task> list) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);
        for (Task task : list) {
            fw.write(task.toFileFormat() + System.lineSeparator());
        }
        fw.close();
    }

    public ArrayList<Task> load() throws FileNotFoundException {

        File f = new File(FILE_PATH);
        Scanner s = new Scanner(f);
        ArrayList<Task> list = new ArrayList<>();
        String taskType, status, description, by, from, to, line;
        String[] words;
        while(s.hasNext()) {
            Task newTask = null;
            line = s.nextLine();
            words = line.split("\\|");
            taskType = words[0].trim();
            status = words[1].trim();
            description = words[2].trim();

            switch (taskType) {
            case"T":
                newTask = new Todo(description);
                break;
            case"D":
                by = words[3].trim();
                newTask = new Deadlines(description, by);
                break;
            case"E":
                String[] durations =  words[3].split("-");
                from = durations[0].trim();
                to = durations[1].trim();
                newTask = new Events(description, from, to);
                break;
            }

            if (status.equals("1") && newTask != null) {
                newTask.setToDone();
            }
            list.add(newTask);
        }
        return list;
    }
}
