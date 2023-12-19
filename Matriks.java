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

  private int[][] resultMatrix;

  // Constructor for addition
  public Matriks(int[][] matrix1, int[][] matrix2, String operation) {
        if (operation.equalsIgnoreCase("addition")) {
            performAddition(matrix1, matrix2);
        } else {
            System.out.println("Invalid operation. Please use 'addition', 'subtraction', 'multiplication', or 'division'.");
        }
    }

  // Constructor for subtraction
  public Matriks(int[][] matrix1, int[][] matrix2, boolean isSubtraction) {
        if (isSubtraction) {
            performSubtraction(matrix1, matrix2);
        } else {
            System.out.println("Invalid operation. Please use 'addition', 'subtraction', 'multiplication', or 'division'.");
        }
    }

  // Constructor for multiplication
  public Matriks(int[][] matrix1, int[][] matrix2, int operation) {
        if (operation == 1) {
            performMultiplication(matrix1, matrix2);
        } else {
            System.out.println("Invalid operation. Please use 'addition', 'subtraction', 'multiplication', or 'division'.");
        }
    }

  // Constructor for division
  public Matriks(int[][] matrix1, int[][] matrix2, double operation) {
        if (operation == 1.0) {
            performDivision(matrix1, matrix2);
        } else {
            System.out.println("Invalid operation. Please use 'addition', 'subtraction', 'multiplication', or 'division'.");
        }
    }

  // Perform addition
  private void performAddition(int[][] matrix1, int[][] matrix2) {
    // Implementation for addition
    // Store the result in the resultMatrix field
  }

  // Perform subtraction
  private void performSubtraction(int[][] matrix1, int[][] matrix2) {
    // Implementation for subtraction
    // Store the result in the resultMatrix field
  }

  // Perform multiplication
  private void performMultiplication(int[][] matrix1, int[][] matrix2) {
    // Implementation for multiplication
    // Store the result in the resultMatrix field
  }

  // Perform division
  private void performDivision(int[][] matrix1, int[][] matrix2) {
    // Implementation for division
    // Store the result in the resultMatrix field
  }

  // Method to display the result matrix
  public void displayResultMatrix() {
    // Display the resultMatrix
  }

  // Example usage in main method
    int[][] matrix1 = { { 1, 2 }, { 3, 4 } };
    int[][] matrix2 = { { 5, 6 }, { 7, 8 } };

    // Example usage of addition constructor
    Matriks additionCalculator = new Matriks(matrix1, matrix2, "addition");

    // Example usage of subtraction constructor
    Matriks subtractionCalculator = new Matriks(matrix1, matrix2, true);

    // Example usage of multiplication constructor
    Matriks multiplicationCalculator = new Matriks(matrix1, matrix2, 1);

    // Example usage of division constructor
    Matriks divisionCalculator = new Matriks(matrix1, matrix2, 1.0);
  }