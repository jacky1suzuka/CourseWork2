import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер команды, чтобы выбрать действие.\n----------" +
                    "\n1.Создать задачу" +
                    "\n2.Получить задачу" +
                    "\n3.Завершить работу\n");
            String command = scanner.next();
            if (command.equals("1")) {
                while (true) {
                    System.out.println("Введите название задачи");
                    String title = scanner1.nextLine();
                    System.out.println("Введите описание");
                    String description = scanner1.nextLine();
                    Task task = new Task(title, description);
                    System.out.println("Задача создана:\n\n" + task);
                    TaskService.taskMap.put(task.getId(),task);
                    System.out.println("\nЧтобы продолжить, введите любое значение.");
                    String anyKey = scanner1.nextLine();
                    break;
                }
            } else if (command.equals("2")){
                Scanner scanner2 = new Scanner(System.in);
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Введите id");
                Integer id = null;
                try {
                    id = scanner2.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Неккоретный id\n----------");
                    continue;
                }
                System.out.println("Задача найдена:");
                System.out.println(TaskService.taskMap.get(id));
                System.out.println("\nЧтобы продолжить, введите любое значение.");
                String anyKey = scanner3.nextLine();
            } else if (command.equals("3")) {
                break;
            }
        }
    }
}