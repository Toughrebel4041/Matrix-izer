import java.util.Scanner;

public class Matrix {

    private int[][] resultMatrix;
    private double determinantResult;

    // Constructor for matrix operations
    public Matrix(int[][] matrix1, int[][] matrix2) {
        displayMenu();  // Memanggil metode untuk menampilkan menu operasi matriks
        performOperation(matrix1, matrix2);  // Memanggil metode untuk melakukan operasi matriks
    }

    // Constructor to calculate transpose
    public Matrix(int[][] matrix) {
        calculateTranspose(matrix);  // Memanggil metode untuk menghitung transpose
    }

    // Constructor to calculate determinant
    public Matrix(int[][] matrix, boolean isDeterminant) {
        calculateDeterminant(matrix);  // Memanggil metode untuk menghitung determinan
    }

    // Display the menu
    private void displayMenu() {
        System.out.println("Matrix Calculator Menu:");  // Menampilkan judul menu
        System.out.println("1. Addition");  // Menampilkan pilihan operasi penjumlahan
        System.out.println("2. Subtraction");  // Menampilkan pilihan operasi pengurangan
        System.out.println("3. Multiplication");  // Menampilkan pilihan operasi perkalian
        System.out.println("4. Division");  // Menampilkan pilihan operasi pembagian
        System.out.println("5. Transpose");  // Menampilkan pilihan operasi transpose
        System.out.println("6. Determinant");  // Menampilkan pilihan operasi determinan
        System.out.print("Choose an operation (1-6): ");  // Meminta pengguna untuk memilih operasi
    }

    // Perform the selected matrix operation
    private void performOperation(int[][] matrix1, int[][] matrix2) {
        Scanner scanner = new Scanner(System.in);  // Membuat objek Scanner untuk input dari pengguna
        int choice = scanner.nextInt();  // Membaca pilihan operasi dari pengguna

        switch (choice) {
            case 1:
                performAddition(matrix1, matrix2);  // Memanggil metode untuk penjumlahan matriks
                break;
            case 2:
                performSubtraction(matrix1, matrix2);  // Memanggil metode untuk pengurangan matriks
                break;
            case 3:
                performMultiplication(matrix1, matrix2);  // Memanggil metode untuk perkalian matriks
                break;
            case 4:
                performDivision(matrix1, matrix2);  // Memanggil metode untuk pembagian matriks
                break;
            case 5:
                calculateTranspose(matrix1);  // Memanggil metode untuk menghitung transpose matriks
                break;
            case 6:
                calculateDeterminant(matrix1);  // Memanggil metode untuk menghitung determinan matriks
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 6.");  // Menampilkan pesan jika pilihan tidak valid
        }

        scanner.close();  // Menutup objek Scanner
    }

    // Perform addition
    private void performAddition(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            resultMatrix = new int[matrix1.length][matrix1[0].length];  // Membuat matriks hasil penjumlahan
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];  // Menjumlahkan elemen-elemen matriks
                }
            }
            System.out.println("Result of Addition:");  // Menampilkan hasil penjumlahan matriks
            printMatrix(resultMatrix);  // Memanggil metode untuk menampilkan matriks
        } else {
            System.out.println("Matrices must have the same dimensions for addition.");  // Menampilkan pesan jika dimensi matriks tidak sesuai
        }
    }

    // Perform subtraction
    private void performSubtraction(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            resultMatrix = new int[matrix1.length][matrix1[0].length];  // Membuat matriks hasil pengurangan
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];  // Mengurangkan elemen-elemen matriks
                }
            }
            System.out.println("Result of Subtraction:");  // Menampilkan hasil pengurangan matriks
            printMatrix(resultMatrix);  // Memanggil metode untuk menampilkan matriks
        } else {
            System.out.println("Matrices must have the same dimensions for subtraction.");  // Menampilkan pesan jika dimensi matriks tidak sesuai
        }
    }

    // Perform multiplication
    private void performMultiplication(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length == matrix2.length) {
            resultMatrix = new int[matrix1.length][matrix2[0].length];  // Membuat matriks hasil perkalian
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];  // Mengalikan dan menjumlahkan elemen-elemen matriks
                    }
                }
            }
            System.out.println("Result of Multiplication:");  // Menampilkan hasil perkalian matriks
            printMatrix(resultMatrix);  // Memanggil metode untuk menampilkan matriks
        } else {
            System.out.println("Invalid dimensions for multiplication.");  // Menampilkan pesan jika dimensi matriks tidak sesuai
        }
    }

    // Perform division
    private void performDivision(int[][] matrix1, int[][] matrix2) {
        System.out.println("Matrix division is not supported in this version.");  // Menampilkan pesan bahwa pembagian matriks tidak didukung
        // You can implement matrix division logic if needed
    }

    // Calculate transpose
    private void calculateTranspose(int[][] matrix) {
        resultMatrix = new int[matrix[0].length][matrix.length];  // Membuat matriks hasil transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[j][i] = matrix[i][j];  // Mengisi elemen-elemen matriks hasil transpose
            }
        }
        System.out.println("Result of Transpose:");  // Menampilkan hasil transpose matriks
        printMatrix(resultMatrix);  // Memanggil metode untuk menampilkan matriks
    }

    // Calculate determinant
    private void calculateDeterminant(int[][] matrix) {
        if (matrix.length == matrix[0].length) {
            determinantResult = calculateDeterminantRecursive(matrix);  // Menghitung determinan menggunakan metode rekursif
            System.out.println("Determinant: " + determinantResult);  // Menampilkan hasil determinan
        } else {
            System.out.println("Matrix must be square to calculate determinant.");  // Menampilkan pesan jika matriks tidak persegi
        }
    }

    // Recursive method to calculate determinant
    private double calculateDeterminantRecursive(int[][] matrix) {
        int n = matrix.length;
        double determinant = 0;

        if (n == 1) {
            determinant = matrix[0][0];  // Basis case: determinan untuk matriks 1x1
        } else if (n == 2) {
            determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);  // Basis case: determinan untuk matriks 2x2
        } else {
            for (int i = 0; i < n; i++) {
                int[][] submatrix = createSubmatrix(matrix, i);  // Membuat submatriks untuk perhitungan determinan
                determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminantRecursive(submatrix);  // Rekursif: menambahkan determinan submatriks dengan tanda yang sesuai
            }
        }

        return determinant;
    }

    // Create submatrix for determinant calculation
    private int[][] createSubmatrix(int[][] matrix, int col) {
        int n = matrix.length;
        int[][] submatrix = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            int subCol = 0;
            for (int j = 0; j < n; j++) {
                if (j != col) {
                    submatrix[i - 1][subCol++] = matrix[i][j];  // Mengisi submatriks dengan elemen-elemen yang sesuai
                }
            }
        }
        return submatrix;
    }

    // Method to print a matrix
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");  // Menampilkan elemen-elemen matriks
            }
            System.out.println();
        }
    }

    // Method to input elements for a matrix
    private static int[][] inputMatrix(int rows, int cols, String matrixName, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for matrix " + matrixName + ":");  // Meminta pengguna untuk memasukkan elemen-elemen matriks
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();  // Membaca elemen-elemen matriks dari input pengguna
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

        // Creating a Matrix object with the input matrices
        new Matrix(matrix1, matrix2);

        // Creating a Matrix object to calculate the transpose
        System.out.println("\nCalculating Transpose of the First Matrix:");
        new Matrix(matrix1);

        // Creating a Matrix object to calculate the determinant
        System.out.println("\nCalculating Determinant of the First Matrix:");
        new Matrix(matrix1, true);

        scanner.close();  // Menutup objek Scanner
    }
}
