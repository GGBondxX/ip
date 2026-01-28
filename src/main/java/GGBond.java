import java.util.Arrays;
import java.util.Scanner;

public class GGBond {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        System.out.println("----------------------------------------------------");
        System.out.println("Hello! I'm GGBond.\n"  + " What can I do for you?\n");
        line = in.nextLine();
        String[] words = line.split(" ");
        while (!(words[0].equals("bye"))) {
            System.out.println(line);
            line = in.nextLine();
            words = line.split(" ");
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("----------------------------------------------------");
    }
}
