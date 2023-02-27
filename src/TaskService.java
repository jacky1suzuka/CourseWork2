import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();

    public static String start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер команды, чтобы выбрать действие.\n----------" +
                "\n1.Создать задачу" +
                "\n2.Удалить задачу" +
                "\n3.Получить задачу по id" +
                "\n4.Получить задачи по дате" +
                "\n5.Завершить работу");
        return scanner.next();
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
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
            System.out.println("Выберите повторяемость: 1 - Ежегодная, 2 - Ежемесячная, 3 - Еженедельная, 4 - Ежедневная, 5 - Однократная");
            String repeatability = scanner2.nextLine();
            Task task = null;
            switch (repeatability) {
                case "1":
                    task = new YearlyTask(title, type, description);
                    task.setRepeatability("Ежегодная");
                    break;
                case "2":
                    task = new MonthlyTask(title, type, description);
                    task.setRepeatability("Ежемесячная");
                    break;
                case "3":
                    task = new WeeklyTask(title, type, description);
                    task.setRepeatability("Еженедельная");
                    break;
                case "4":
                    task = new DailyTask(title, type, description);
                    task.setRepeatability("Ежедневная");
                    break;
                case "5":
                    task = new OneTimeTask(title, type, description);
                    task.setRepeatability("Однократная");
                    break;
                default:
                    System.out.println("Введено некорректное значение!");
                    return;
            }
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

    public static Collection<Task> getAllByDate() {
        Collection<Task> relevantTasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату");
        String dateString = scanner.nextLine();
        LocalDate parsedDate = null;
        try {
            parsedDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("Неккоретная дата");
            return relevantTasks;
        }
        for (Map.Entry<Integer, Task> taskEntry : taskMap.entrySet()) {
            if (taskEntry.getValue().appearsIn(parsedDate)) {
                relevantTasks.add(taskEntry.getValue());
            }
        }
        if (relevantTasks.isEmpty()) {
            System.out.println("Задачи не найдены");
        }
        return relevantTasks;
    }

    public static void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id задачи для удаления");
        int id = 0;
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
            taskMap.remove(id);
            System.out.println("Задача удалена.");
        } else {
            System.out.println("Такой задачи нет");
        }
    }
}
