import java.util.Scanner;
// Nguyen Manh Hieu 20215050

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;

        double quotient = 0;
        if (number2 != 0) {
            quotient = number1 / number2;
        } else {
            System.out.println("Cannot divide by zero.");
        }

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        scanner.close();
    }
}
