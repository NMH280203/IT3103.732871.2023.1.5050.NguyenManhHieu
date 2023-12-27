
import java.util.Scanner;
// Nguyen Manh Hieu 20215050
public class EquationSolver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose the type of equation: linear, system, or quadratic");
        String equationType = input.next().toLowerCase();

        if (equationType.equals("linear")) {
            // Solve a first-degree equation (linear equation) with one variable
            System.out.println("Enter the coefficients 'a' and 'b' for the equation ax + b = 0:");
            double a = input.nextDouble();
            double b = input.nextDouble();
            solveLinearEquation(a, b);
        } else if (equationType.equals("system")) {
            // Solve a system of first-degree equations (linear system) with two variables
            System.out.println("Enter the coefficients a11, a12, b1, a21, a22, and b2 for the system:");
            double a11 = input.nextDouble();
            double a12 = input.nextDouble();
            double b1 = input.nextDouble();
            double a21 = input.nextDouble();
            double a22 = input.nextDouble();
            double b2 = input.nextDouble();
            solveLinearSystem(a11, a12, b1, a21, a22, b2);
        } else if (equationType.equals("quadratic")) {
            // Solve a second-degree equation (quadratic equation) with one variable
            System.out.println("Enter the coefficients 'a', 'b', and 'c' for the equation ax^2 + bx + c = 0:");
            double a = input.nextDouble();
            double b = input.nextDouble();
            double c = input.nextDouble();
            solveQuadraticEquation(a, b, c);
        } else {
            System.out.println("Invalid equation type. Please choose 'linear', 'system', or 'quadratic'.");
        }

        input.close();
    }

    // Function to solve a first-degree equation with one variable
    public static void solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions (0x = 0)");
            } else {
                System.out.println("No solution (0x = b, where b is non-zero)");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    // Function to solve a system of first-degree equations with two variables
    public static void solveLinearSystem(double a11, double a12, double b1, double a21, double a22, double b2) {
        double determinant = a11 * a22 - a21 * a12;
        if (determinant == 0) {
            if (a11 * b2 - a21 * b1 == 0 && a12 * b2 - a22 * b1 == 0) {
                System.out.println("Infinite solutions (Dependent equations)");
            } else {
                System.out.println("No solution (Inconsistent equations)");
            }
        } else {
            double x1 = (b1 * a22 - b2 * a12) / determinant;
            double x2 = (a11 * b2 - a21 * b1) / determinant;
            System.out.println("The solutions are x1 = " + x1 + " and x2 = " + x2);
        }
    }

    // Function to solve a second-degree equation with one variable
    public static void solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinite solutions (0x^2 + 0x + 0 = 0)");
                } else {
                    System.out.println("No solution (0x^2 + 0x + c = 0, where c is non-zero)");
                }
            } else {
                double x = -c / b;
                System.out.println("The solution is x = " + x);
            }
        } else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The solutions are x1 = " + x1 + " and x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Double root: x = " + x);
        } else {
            System.out.println("No real roots (Discriminant is negative)");
        }
    }
}
