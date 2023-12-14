import java.util.Scanner;
// Nguyen Manh Hieu 20215050
public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the dimensions of the matrices
        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();

        // Initialize two matrices
        int[][] matrixA = new int[numRows][numCols];
        int[][] matrixB = new int[numRows][numCols];
        int[][] resultMatrix = new int[numRows][numCols];

        // Input the values of the first matrix
        System.out.println("Enter values for the first matrix:");
        inputMatrixValues(matrixA, scanner);

        // Input the values of the second matrix
        System.out.println("Enter values for the second matrix:");
        inputMatrixValues(matrixB, scanner);

        // Add the two matrices
        addMatrices(matrixA, matrixB, resultMatrix);

        // Display the result
        System.out.println("Resultant Matrix:");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    // Function to input values for a matrix
    public static void inputMatrixValues(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter the value at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Function to add two matrices and store the result in a third matrix
    public static void addMatrices(int[][] matrixA, int[][] matrixB, int[][] resultMatrix) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }

    // Function to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
