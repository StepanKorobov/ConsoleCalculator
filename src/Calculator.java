import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstNumber = getValue();
        int secondNumber = getValue();
        char action = getArithmeticOperations();
        double result = calculate(firstNumber, secondNumber, action);
        printResult(result, action);
    }

    public static int getValue() {
        // Запрос числа у пользователя
        System.out.println("Введите первое число: ");
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException exc) {
                System.out.println("Ошибка: Ожидалось число, а не текст.\nПовторите ввод:");
                scanner.nextLine();
            }
        }
    }

    public static char getArithmeticOperations() {
        // Запрос действия (+ - * /)
        System.out.println("Введите операцию: ");
        while (true) {
            try {
                char action = scanner.next().charAt(0);
                if (checkArithmeticOperations(action)) {
                    scanner.nextLine();
                    return action;
                }
            } catch (InputMismatchException exc) {
                System.out.println("ААА");
                scanner.nextLine();
            }
        }
    }

    public static boolean checkArithmeticOperations(char current_action) {
        // Валидация введённого пользователем символа/знака
        char[] actions = {'+', '-', '*', '/'};
        for (char action : actions) {
            if (action == current_action) {
                return true;
            }
        }
        throw new InputMismatchException("f");
    }

    public static double calculate(int firstNumber, int secondNumber, char operation) {
        // Рассчитываем значение в зависимости от арифметического оператора
        double result = 0;
        switch (operation) {
            case '+':
                result = (double) firstNumber + secondNumber;
                break;
            case '-':
                result = (double) firstNumber - secondNumber;
                break;
            case '*':
                result = (double) firstNumber * secondNumber;
                break;
            case '/':
                result = (double) firstNumber / secondNumber;
                break;
            default:
                System.out.println("Ошибка: неизвестная команда.");
        }
        return result;
    }

    public static void printResult(double result, char operation) {
        // Вывод результата, для удобства вывода сделано преобразование данных в long при операциях / - *
        if (operation == '/') {
            System.out.println("Результат: " + result);
        } else System.out.println("Результат: " + (long) result);
    }
}