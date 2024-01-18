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

    public void printData(int day, int month) {
        MonthData getValue = (MonthData) monthToDate.get(month);
        int steps = getValue.printDataDay(day);
        System.out.println("В этот день вы прошли " + steps + " шагов.");
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

    public int printDataDay(int day) {
        return stepsPerDay[day - 1];
    }

}
