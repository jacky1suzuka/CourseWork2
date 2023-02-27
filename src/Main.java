import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        while (true) {
            String command = TaskService.start();
            switch (command) {
                case "1":
                    TaskService.add();
                    break;
                case "2":
                    TaskService.remove();
                    break;
                case "3":
                    TaskService.get();
                    break;
                case "4":
                    Collection<Task> tasks = TaskService.getAllByDate();
                    if (!tasks.isEmpty()) {
                        for (Task task : tasks) {
                            System.out.println(task);
                        }
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Введите корректное значение!");
                    break;
            }
        }
    }
}