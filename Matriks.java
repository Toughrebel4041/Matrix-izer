import java.util.Scanner;

public class Matriks {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of rows for the first matrix:");
    int rows1 = scanner.nextInt();

    System.out.println("Enter the number of columns for the first matrix:");
    int columns1 = scanner.nextInt();

    int[][] matrix1 = new int[rows1][columns1];

    // Read user input for the first matrix
    for (int row = 0; row < rows1; row++) {
      for (int col = 0; col < columns1; col++) {
        System.out.print("Enter element (" + (row + 1) + ", " + (col + 1) + ") (or 'x' for missing data): ");
        String input = scanner.nextLine();
        if (input.equals("x")) {
          matrix1[row][col] = -1; // set a sentinel value for missing data
        } else {
          matrix1[row][col] = Integer.parseInt(input);
        }
      }
    }

    // (Repeat the above process for the second matrix if needed)

    // Print the first matrix
    System.out.println("\nFirst Matrix:");
    for (int[] row : matrix1) {
      for (int element : row) {
        if (element == -1) {
          System.out.print("| x |");
        } else {
          System.out.print("| " + element + " |");
        }
      }
      System.out.println();
    }

    scanner.close();
  }
}
