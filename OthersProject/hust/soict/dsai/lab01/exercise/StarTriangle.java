import java.util.Scanner;
//Nguyen Manh Hieu 20215050
public class StarTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the height of the triangle (n): ");
        int n = scanner.nextInt();
        
        if (n < 1) {
            System.out.println("Please enter a positive integer.");
            extracted();
        }
        
        for (int i = 1; i <= n; i++) {
            // Print spaces before the stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            
            // Move to the next line
            System.out.println();
        }
        
        scanner.close();
    }

    private static void extracted() {
    }
}
