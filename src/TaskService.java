import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();

    public static String start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер команды, чтобы выбрать действие.\n----------" +
                "\n1.Создать задачу" +
                "\n2.Получить задачу" +
                "\n3.Завершить работу\n");
        return scanner.next();
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название задачи");
            String title = scanner.nextLine();
            System.out.println("Выберите тип задачи: 1 - личная, 2 - рабочая");
            Type type;
            String input = scanner1.nextLine();
            if (input.equals("1")) {
                type = Type.PERSONAL;
            } else if (input.equals("2")) {
                type = Type.WORK;
            } else {
                System.out.println("Введено некорректное значение!");
                break;
            }
            System.out.println("Введите описание");
            String description = scanner.nextLine();
            Task task = new Task(title, type , description);
            System.out.println("Задача создана:\n\n" + task);
            TaskService.taskMap.put(task.getId(),task);
            System.out.println("\nЧтобы продолжить, введите любое значение.");
            String anyKey = scanner.nextLine();
            break;
        }
    }

    public static void get() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        Integer id = null;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("----------\nВведен некорректный номер задачи!\n----------");
            System.out.println("Чтобы продолжить, введите любое значение");
            Scanner scanner1 = new Scanner(System.in);
            String anyKey = scanner1.nextLine();
            return;
        }
        if (taskMap.containsKey(id)) {
            System.out.println("Задача найдена:\n---------- ");
            System.out.println(taskMap.get(id));
        } else {
            System.out.println("Задача не найдена");
        }
        System.out.println("----------\nЧтобы продолжить, введите любое значение");
        String anyKey = scanner.next();
    }
}
