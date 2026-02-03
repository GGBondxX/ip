import java.util.Arrays;
import java.util.Scanner;

public class GGBond {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task[] list = new Task[100];
        int inputCounter = 0;
        int taskNumber = 0;
        String line;

        System.out.println("----------------------------------------------------");
        System.out.println("Hello! I'm GGBond.\n"  + " What can I do for you?\n");
        System.out.println("----------------------------------------------------");
        line = in.nextLine();
        String[] words = line.split(" ");

        while (!(words[0].equals("bye"))) {
            if(words[0].equals("list")) {
                int displayInputCount = 1;
                System.out.println("----------------------------------------------------");
                for (int i = 0; i < inputCounter; i++) {
                    System.out.printf("%d.%s\n" , displayInputCount, list[i].toString());
                    displayInputCount++;
                }
                System.out.println("----------------------------------------------------");
            }
            else if (words[0].equals("mark")) {
                taskNumber =Integer.parseInt(words[1]) - 1;
                list[taskNumber].setToDone();
                System.out.println("----------------------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.printf("%s\n",list[taskNumber].toString());
                System.out.println("----------------------------------------------------");
            }
            else if (words[0].equals("unmark")) {
                taskNumber =Integer.parseInt(words[1]) - 1;
                list[taskNumber].setToUndone();
                System.out.println("----------------------------------------------------");
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.printf("%s\n",list[taskNumber].toString());
                System.out.println("----------------------------------------------------");
            }
            else if (words[0].equals("todo")) {
                inputCounter = addToTaskList(list, words, inputCounter, TaskType.TODO);
            }
            else if (words[0].equals("deadline")) {
                inputCounter = addToTaskList(list, words, inputCounter, TaskType.DEADLINES);
            }
            else if (words[0].equals("event")) {
                inputCounter = addToTaskList(list, words, inputCounter, TaskType.EVENT);
            }
            else {
                inputCounter = addToTaskList(list, words, inputCounter, TaskType.BASE);

            }
            line = in.nextLine();
            words = line.split(" ");

        }
        System.out.println("----------------------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("----------------------------------------------------");
    }

    public static int addToTaskList(Task[] list, String[] words, int inputCounter, TaskType type) {
        if (type == TaskType.BASE) {
            String line = String.join(" ", words);
            list[inputCounter] = new Task(line);
            printAddMessage(list, inputCounter);
            return ++inputCounter;
        }

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
        switch(type) {
        case TODO :
            list[inputCounter] = new Todo(description);
            break;
        case DEADLINES :
            list[inputCounter] = new Deadlines(description, by);
            break;
        case EVENT :
            list[inputCounter] = new Events(description, from, to);
            break;
        }
        printAddMessage(list, inputCounter);
        return ++inputCounter;
    }

    public static void printAddMessage(Task[] list, int inputCounter) {
        System.out.println("----------------------------------------------------");
        System.out.println("Got it. I've added this task:");
        System.out.printf("%s\n", list[inputCounter].toString());
        System.out.printf("Now you have %d tasks in the list\n", inputCounter+1);
        System.out.println("----------------------------------------------------");
    }
}
