import task.Task;

public class ListCommand extends Command{


    @Override
    public int execute(Task[] list, int inputCounter) {
        int displayInputCount = 1;
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < inputCounter; i++) {
            System.out.printf("%d.%s\n", displayInputCount, list[i].toString());
            displayInputCount++;
        }
        System.out.println("----------------------------------------------------");
        return inputCounter;
    }
}
