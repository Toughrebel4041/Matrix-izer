import java.util.Scanner;

public class Matriks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first matrix
        System.out.print("Enter the number of rows for the first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns for the first matrix: ");
        int cols1 = scanner.nextInt();
        int[][] matrix1 = inputMatrix(rows1, cols1, "first", scanner);

        // Input for the second matrix
        System.out.print("Enter the number of rows for the second matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for the second matrix: ");
        int cols2 = scanner.nextInt();
        int[][] matrix2 = inputMatrix(rows2, cols2, "second", scanner);

        // Display the entered matrices
        System.out.println("\nFirst Matrix:");
        printMatrix(matrix1);

        System.out.println("\nSecond Matrix:");
        printMatrix(matrix2);

        scanner.close();
    }

    // Function to input elements for a matrix
    private static int[][] inputMatrix(int rows, int cols, String matrixName, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements for the " + matrixName + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Function to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
