import java.util.Scanner;

public class DepositCalculator {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new calculateDeposit().startTheCalculator();
    }

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return calculatePercent(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculatePercent(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculatePercent(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void startTheCalculator() {
        int period;
        int action;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double contributionResult = 0;
        if (action == 1) {
            contributionResult = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            contributionResult = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period
                + " лет превратятся в " + contributionResult);
    }


}
