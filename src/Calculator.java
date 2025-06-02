import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Calculator {
    private static final Map<Character, BinaryOperator<Double>> operations  = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        operations.put('+', Double::sum);
        operations.put('-', (a, b) -> a - b);
        operations.put('*', (a, b) -> a * b);
        operations.put('/', (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Zero division");
            }
            return a / b;
        });
    }

    public static void calculate () {
        boolean continueCalculation = true;

        do {
            double firstNumber = getNum(scanner);
            char operatorChar = getOperation(scanner);
            double secondNumber = getNum(scanner);

            BinaryOperator<Double> operation = operations.get(operatorChar);
            try {
                double result = operation.apply(firstNumber, secondNumber);
                System.out.println("Result is: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to continue?");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("+")) {
                continueCalculation = false;
            }

        } while (continueCalculation);
        System.out.println("Calculate are closed");

    }

    public static int getNum(Scanner scanner) {
        while (true) {
            System.out.println("Enter number: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Illegal number");
                scanner.nextLine();
            }
        }
    }

    public static char getOperation(Scanner scanner) {
        while (true) {
            System.out.print("Enter operation (+, -, *, /): ");
            String input = scanner.next();
            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                } else {
                    System.out.println("Invalid operation. Try again.");
                }
            } else {
                System.out.println("Please enter a single character operation.");
            }
        }
    }
}
