import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker myTracker = new StepTracker();
        System.out.println("Приветствуем вас пользователь!");
        Scanner sc = new Scanner(System.in);
        printMenu();
        int chose = sc.nextInt();

        while (chose != 0) {
            if (chose == 1) {
                System.out.println("Введите номер месяца от 1 до 12");
                int month = sc.nextInt();
                while (month > 12 || month < 1) {
                    System.out.println("Нету такого месяца. Попробуйте еще!");
                    month = sc.nextInt();
                }

                System.out.println("Введите день от 1 до 30.");
                int day = sc.nextInt();
                while (day > 30 || day < 1) {
                    System.out.println("Нету такого дня. Попробуйте еще!");
                    day = sc.nextInt();
                }

                System.out.println("Введите количество пройденных шагов.");
                int steps = sc.nextInt();
                while (steps < 0) {
                    System.out.println("Значение не может быть отрицательным, попробуйде еще");
                    steps = sc.nextInt();
                }

                myTracker.saveProgress(month, day, steps);
                System.out.println("Прогресс сохранен.");
            } else if (chose == 2) {
                System.out.println("Введите номер месяца от 1 до 12");
                int month = sc.nextInt();
                while (month > 12 || month < 1) {
                    System.out.println("Нету такого месяца. Попробуйте еще!");
                    month = sc.nextInt();
                }

                System.out.println("Введите день от 1 до 30.");
                int day = sc.nextInt();
                while (day > 30 || day < 1) {
                    System.out.println("Нету такого дня. Попробуйте еще!");
                    day = sc.nextInt();
                }

                myTracker.printData(day, month);

            }
            printMenu();
            chose = sc.nextInt();
        }
        System.out.println("Всего доброго!");
    }

    public static void printMenu() {
        System.out.println("Выберите нужную команду.");
        System.out.println("1 - Записать результат.");
        System.out.println("2 - Вывод прогресса");
    }
}