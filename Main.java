import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long earnings = 0;
        long spendings = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Введите 'end' для завершения.");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            try {
                int operation = Integer.parseInt(input);

                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        long addEarnings = Long.parseLong(scanner.nextLine());
                        earnings += addEarnings;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        long addSpendings = Long.parseLong(scanner.nextLine());
                        spendings += addSpendings;
                        break;
                    case 3:
                        long taxEarnings = taxEarnings(earnings);
                        long taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);

                        if (taxEarnings < taxEarningsMinusSpendings) {
                            long economy = taxEarningsMinusSpendings - taxEarnings;
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: " + taxEarnings + " рублей");
                            System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings + " рублей");
                            System.out.println("Экономия: " + economy + " рублей");
                        } else if (taxEarningsMinusSpendings < taxEarnings) {
                            long economy = taxEarnings - taxEarningsMinusSpendings;
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings + " рублей");
                            System.out.println("Налог на другой системе: " + taxEarnings + " рублей");
                            System.out.println("Экономия: " + economy + " рублей");
                        } else {
                            System.out.println("Можете выбрать любую систему налогообложения.");
                            System.out.println("Налог на обеих системах составит: " + taxEarnings + " рублей");
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите номер операции (1, 2, 3) или 'end'.");
            }
        }
        System.out.println("Программа завершена!");
    }

    public static long taxEarnings(long earnings) {
        return earnings * 6 / 100;
    }

    public static long taxEarningsMinusSpendings(long earnings, long spendings) {
        long tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}