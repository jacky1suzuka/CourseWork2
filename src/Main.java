import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер команды, чтобы выбрать действие\n - - - - - - \n1.Создать задачу\n2.Завершить работу\n");
        while (true) {
            String command = scanner.next();
            if (command.equals("1")) {
                System.out.println("Введите название задачи");
                String title = scanner.next();
                System.out.println("Введите описание");
                String description = scanner.next();
                Task task = new Task(title, description);
                System.out.println("Ваша задача:\n" + task);
                break;
            } else if (command.equals("2")) {
                System.out.println("Работа завершена.");
                break;
            } else {
                System.out.println("Введите корректный номер команды");
            }
        }
    }
}