

public class Main {
    public static void main(String[] args) {

        label:
        while (true) {
            String command = TaskService.start();
            switch (command) {
                case "1":
                    TaskService.add();
                    break;
                case "2":
                    TaskService.get();
                    break;
                case "3":
                    break label;
                default:
                    System.out.println("Перезапустите программу и введите корректное значение!");
                    break label;
            }
        }
    }
}