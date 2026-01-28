import java.util.Arrays;
import java.util.Scanner;

public class GGBond {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task[] list = new Task[100];
        int inputCounter = 0;
        int taskNumber;
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
                    System.out.printf("%d.[%s] %s\n" , displayInputCount, list[i].getStatusIcon(), list[i].description);
                    displayInputCount++;
                }
                System.out.println("----------------------------------------------------");
            }
            else if (words[0].equals("mark")) {
                taskNumber =Integer.parseInt(words[1]) - 1;
                list[taskNumber].setToDone();
                System.out.println("----------------------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.printf("[%s] %s\n",list[taskNumber].getStatusIcon(), list[taskNumber].description);
                System.out.println("----------------------------------------------------");
            }
            else if (words[0].equals("unmark")) {
                taskNumber =Integer.parseInt(words[1]) - 1;
                list[taskNumber].setToUndone();
                System.out.println("----------------------------------------------------");
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.printf("[%s] %s\n",list[taskNumber].getStatusIcon(), list[taskNumber].description);
                System.out.println("----------------------------------------------------");
            }
            else {
                list[inputCounter] = new Task(line);
                inputCounter++;
                System.out.println("----------------------------------------------------");
                System.out.printf("added: %s\n", line);
                System.out.println("----------------------------------------------------");
            }
            line = in.nextLine();
            words = line.split(" ");

        }
        System.out.println("----------------------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("----------------------------------------------------");
    }
}
