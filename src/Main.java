import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            System.out.println(
                    "Выберите операцию и введите её номер:\n" +
                            "1. Добавить новый доход\n" +
                            "2. Добавить новый расход\n" +
                            "3. Выбрать ситему налогооблажения");

            String input = sc.nextLine();
            if ("end".equals(input))
                break;

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = sc.nextLine(); // Не используйте тут nextInt (!)
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String rastStr = sc.nextLine(); // Не используйте тут nextInt (!)
                    int rast = Integer.parseInt(rastStr);
                    spendings += rast;
                    break;
                case 3:
                    double nalog = ((double) earnings / 100) * 6;
                    double nalog2 = taxEarningsMinusSpendings(earnings, spendings);
                    if (nalog2 > nalog) {
                        System.out.println("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: " + nalog + " рублей\n" +
                                "Налог на другой системе: " + nalog2 + " рублей\n" +
                                "Экономия: " + (nalog2 - nalog) + " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы\n" +
                                "Ваш налог составит: " + nalog2 + " рублей\n" +
                                "Налог на другой системе: " + nalog + " рублей\n" +
                                "Экономия: " + (nalog - nalog2) + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    public static double taxEarningsMinusSpendings(int earnings, int spendings) {
        double tax = ((double) earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }
}