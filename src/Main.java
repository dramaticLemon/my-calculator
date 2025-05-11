import java.util.Scanner;


public class Main {
    private static char operator;
    private static Scanner scanner = new Scanner(System.in);
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        do {
            int firstNumber = getNum(scanner);
            int secondNumber = getNum(scanner);
            operator = getOperation(scanner);
            try {
                switch (operator) {
                    case '+' -> System.out.println(calculator.add(firstNumber, secondNumber));
                    case '-' -> System.out.println(calculator.subtract(firstNumber, secondNumber));
                    case '*' -> System.out.println(calculator.multiply(firstNumber, secondNumber));
                    case '/' -> System.out.println(calculator.divide(firstNumber, secondNumber));
                    case 'q' -> {
                        break;
                    }
                    default -> System.out.println("Unknown operation");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!(operator == 'q'));
        scanner.close();
        System.out.println("Exit");
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
            System.out.print("Enter operation (+, -, *, /, q): ");
            String input = scanner.next();
            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/' || op == 'q') {
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
