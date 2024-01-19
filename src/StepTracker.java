import java.util.HashMap;

public class StepTracker {

    int dailyTarget = 10000;
    HashMap<Integer, MonthData> monthToDate = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToDate.put(i, new MonthData());
        }
    }

    public void saveProgress(int month, int day, int steps) {
        MonthData setValue = (MonthData) monthToDate.get(month);
        setValue.addSteps(day, steps);
    }

    public void printDataStepsPerDay(int day, int month) {
        MonthData getValue = (MonthData) monthToDate.get(month);
        int steps = getValue.stepsPerDay(day);
        System.out.println(day + " день: " + steps);
    }
    public void printAllStepsPerMonth(int month) {
        MonthData getValue = (MonthData) monthToDate.get(month);
        System.out.println("Общее количество пройденных шагов за " + month + " месяц: " + getValue.stepsPerMonth());
    }
    public void printStatisticPerMonth(int month) {
        MonthData getValue = (MonthData) monthToDate.get(month);

        Converter converter = new Converter();

        String statisticsPerDays = "";
        for (int i = 1; i <= 30; i++) {
            statisticsPerDays += i + " день: " + getValue.stepsPerDay(i);
            if (i != 30) {
                statisticsPerDays += ", ";
            }
        }

        System.out.println(statisticsPerDays);
        printAllStepsPerMonth(month);
        System.out.println("Максимальное количество пройденных шагов за день: " + getValue.maxStep());
        System.out.println("Среднее количество пройденных шагов за месяц: " + (getValue.stepsPerMonth() / 30));
        System.out.println("Вы прошли " + (converter.distance(getValue.stepsPerMonth())) + " метров.");
        System.out.println("Вы сожгли " + (converter.kCalories(getValue.stepsPerMonth())) + " килокалорий");
        System.out.println("Лучшая серя дней достигших цели в 10.000 шагов: " + bestSeries(month));
    }

    public int bestSeries(int month) {
        MonthData getValue = (MonthData) monthToDate.get(month);
        int max1 = 0;
        int max2 = 0;

        for (int i = 1; i <= 30; i++) {
            int target = getValue.stepsPerDay(i);

            if (target >= dailyTarget) {
                max1++;
                continue;
            }
            if (max1 > max2) {
                max2 = max1;
            }
            max1 = 0;
        }
        return max2;
    }

}

class MonthData {
    int[] stepsPerDay = new int[30];

    public MonthData() {
        for (int i = 0; i < 30; i++) {
            stepsPerDay[i] = 0;
        }
    }

    public void addSteps(int day, int steps) {
        stepsPerDay[day - 1] = steps;
    }

    public int stepsPerDay(int day) {
        return stepsPerDay[day - 1];
    }
    public int stepsPerMonth() {
        int stepsPerMonth = 0;
        for (int steps : stepsPerDay) {
            stepsPerMonth += steps;
        }
        return stepsPerMonth;
    }
    public int maxStep() {
        int max = 0;
        for (int steps : stepsPerDay) {
            if (steps > max) {
                max = steps;
            }
        }
        return max;
    }

}
