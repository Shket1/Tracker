import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker myTracker = new StepTracker();
        System.out.println("Приветствуем вас пользователь!");
        Scanner sc = new Scanner(System.in);
        printMenu();
        int chose = sc.nextInt();

        while (chose != 0) {
            if (chose == 1) {   //Здесь вводится количество шагов пройденных за день
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
                System.out.println("______________________________________________________________");
            } else if (chose == 2) {  //здесь выводится количество шагов за день
                System.out.println("Введите номер месяца от 1 до 12");
                int month = sc.nextInt();
                while (month > 12 || month < 1) {
                    System.out.println("Нету такого месяца. Попробуйте еще!");
                    month = sc.nextInt();
                }System.out.println("______________________________________________________________");

                System.out.println("Введите день от 1 до 30.");
                int day = sc.nextInt();
                while (day > 30 || day < 1) {
                    System.out.println("Нету такого дня. Попробуйте еще!");
                    day = sc.nextInt();
                }

                myTracker.printDataStepsPerDay(day, month);
                System.out.println("______________________________________________________________");

            } else if (chose == 3) {
                System.out.println("Введите номер месяца от 1 до 12");
                int month = sc.nextInt();
                while (month > 12 || month < 1) {
                    System.out.println("Нету такого месяца. Попробуйте еще!");
                    month = sc.nextInt();
                }
                myTracker.printAllStepsPerMonth(month);
                System.out.println("______________________________________________________________");
            } else if (chose == 4) {
                System.out.println("Введите номер месяца от 1 до 12");
                int month = sc.nextInt();
                while (month > 12 || month < 1) {
                    System.out.println("Нету такого месяца. Попробуйте еще!");
                    month = sc.nextInt();
                }

                myTracker.printStatisticPerMonth(month);
                System.out.println("______________________________________________________________");
            } else if (chose == 5) {
                System.out.println("Введите желаемую цель.");
                int target = sc.nextInt();
                while (target < 0) {
                    System.out.println("Цель не может быть меньше 1");
                    target = sc.nextInt();
                }
                myTracker.dailyTarget = target;
                System.out.println("Целевое количество шагов в сутки установлено на: " + target);
                System.out.println("______________________________________________________________");
            }
            printMenu();
            chose = sc.nextInt();
        }
        System.out.println("Всего доброго!");
    }

    public static void printMenu() {
        System.out.println("Выберите нужную команду.");
        System.out.println("1 - Записать результат.");
        System.out.println("2 - Количество шагов за день");
        System.out.println("3 - Количество шагов за месяц");
        System.out.println("4 - Статистика за месяц");
        System.out.println("5 - Установить цель шагов в день");
        System.out.println("0 - Выход");
    }
}