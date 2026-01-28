import java.util.Arrays;
import java.util.Scanner;

public class GGBond {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] list = new String[100];
        int inputCounter = 0;
        String line;

        System.out.println("----------------------------------------------------");
        System.out.println("Hello! I'm GGBond.\n"  + " What can I do for you?\n");
        System.out.println("----------------------------------------------------");
        line = in.nextLine();

        while (!(line.equals("bye"))) {
            if(line.equals("list")) {
                int displayInputCount = 1;
                System.out.println("----------------------------------------------------");
                for (int i = 0; i < inputCounter; i++) {
                    System.out.printf("%d. %s\n" , displayInputCount, list[i]);
                    displayInputCount++;
                }
                System.out.println("----------------------------------------------------");
            }
            else {
                list[inputCounter] = line;
                inputCounter++;
                System.out.println("----------------------------------------------------");
                System.out.printf("added: %s\n", line);
                System.out.println("----------------------------------------------------");
            }
            line = in.nextLine();
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("----------------------------------------------------");
    }
}
