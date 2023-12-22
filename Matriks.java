import java.util.Scanner;

public class Matriks {

    private int[][] resultMatrix;

    // Constructor for matrix operations
    public Matriks(int[][] matrix1, int[][] matrix2) {
        displayMenu();
        performOperation(matrix1, matrix2);
    }

    // Display the menu
    private void displayMenu() {
        System.out.println("Matrix Calculator Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose an operation (1-4): ");
    }

    // Perform the selected matrix operation
    private void performOperation(int[][] matrix1, int[][] matrix2) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performAddition(matrix1, matrix2);
                break;
            case 2:
                performSubtraction(matrix1, matrix2);
                break;
            case 3:
                performMultiplication(matrix1, matrix2);
                break;
            case 4:
                performDivision(matrix1, matrix2);
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 4.");
        }

        scanner.close();
    }

    // Perform addition
    private void performAddition(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            resultMatrix = new int[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            System.out.println("Result of Addition:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("Matrices must have the same dimensions for addition.");
        }
    }

    // Perform subtraction
    private void performSubtraction(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            resultMatrix = new int[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            System.out.println("Result of Subtraction:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("Matrices must have the same dimensions for subtraction.");
        }
    }

    // Perform multiplication
    private void performMultiplication(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length == matrix2.length) {
            resultMatrix = new int[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            System.out.println("Result of Multiplication:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("Invalid dimensions for multiplication.");
        }
    }

    // Perform division
    private void performDivision(int[][] matrix1, int[][] matrix2) {
        System.out.println("Sorry, there is no thing called Matrix Division.");
        // You can implement matrix division logic if needed
    }

    // Method to print a matrix
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Method to input elements for a matrix
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

    // Main method for testing
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

        // Create a Matriks object with the input matrices
        new Matriks(matrix1, matrix2);

        scanner.close();
    }
}
