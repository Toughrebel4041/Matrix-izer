import java.util.Scanner;

public class Matrix {

    private int[][] matrixHasil;
    private double determinanResult;

    // Konstruktor untuk operasi matriks
    public Matrix(int[][] matriks1, int[][] matriks2) {
        displayMenu();
        performOperation(matriks1, matriks2);
    }

    // Konstruktor untuk menghitung transpose
    public Matrix(int[][] matriks) {
        calculateTranspose(matriks);
    }

    // Konstruktor untuk menghitung determinan
    public Matrix(int[][] matriks, boolean isDeterminant) {
        calculateDeterminant(matriks);
    }

    // Menampilkan menu
    private void displayMenu() {
        System.out.println("Menu Kalkulator Matriks:");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("5. Transpose");
        System.out.println("6. Determinan");
        System.out.print("Pilih operasi (1-6): ");
    }

    // Melakukan operasi matriks yang dipilih
    private void performOperation(int[][] matriks1, int[][] matriks2) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performAddition(matriks1, matriks2);
                break;
            case 2:
                performSubtraction(matriks1, matriks2);
                break;
            case 3:
                performMultiplication(matriks1, matriks2);
                break;
            case 4:
                performDivision(matriks1, matriks2);
                break;
            case 5:
                calculateTranspose(matriks1);
                break;
            case 6:
                calculateDeterminant(matriks1);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih angka antara 1 dan 6.");
        }

        scanner.close();
    }

    // Melakukan penjumlahan
    private void performAddition(int[][] matriks1, int[][] matriks2) {
        if (matriks1.length == matriks2.length && matriks1[0].length == matriks2[0].length) {
            matrixHasil = new int[matriks1.length][matriks1[0].length];
            for (int i = 0; i < matriks1.length; i++) {
                for (int j = 0; j < matriks1[0].length; j++) {
                    matrixHasil[i][j] = matriks1[i][j] + matriks2[i][j];
                }
            }
            System.out.println("Hasil Penjumlahan:");
            displayMatrix(matrixHasil);
        } else {
            System.out.println("Matriks harus memiliki dimensi yang sama untuk penjumlahan.");
        }
    }

    // Melakukan pengurangan
    private void performSubtraction(int[][] matriks1, int[][] matriks2) {
        if (matriks1.length == matriks2.length && matriks1[0].length == matriks2[0].length) {
            matrixHasil = new int[matriks1.length][matriks1[0].length];
            for (int i = 0; i < matriks1.length; i++) {
                for (int j = 0; j < matriks1[0].length; j++) {
                    matrixHasil[i][j] = matriks1[i][j] - matriks2[i][j];
                }
            }
            System.out.println("Hasil Pengurangan:");
            displayMatrix(matrixHasil);
        } else {
            System.out.println("Matriks harus memiliki dimensi yang sama untuk pengurangan.");
        }
    }

    // Melakukan perkalian
    private void performMultiplication(int[][] matriks1, int[][] matriks2) {
        if (matriks1[0].length == matriks2.length) {
            matrixHasil = new int[matriks1.length][matriks2[0].length];
            for (int i = 0; i < matriks1.length; i++) {
                for (int j = 0; j < matriks2[0].length; j++) {
                    for (int k = 0; k < matriks1[0].length; k++) {
                        matrixHasil[i][j] += matriks1[i][k] * matriks2[k][j];
                    }
                }
            }
            System.out.println("Hasil Perkalian:");
            displayMatrix(matrixHasil);
        } else {
            System.out.println("Dimensi yang tidak valid untuk perkalian.");
        }
    }

    // Melakukan pembagian
    private void performDivision(int[][] matriks1, int[][] matriks2) {
        System.out.println("Tidak ada methode pembagian untuk matriks.");
        // Anda dapat mengimplementasikan logika pembagian matriks jika diperlukan
    }

    // Menghitung transpose
    private void calculateTranspose(int[][] matriks) {
        matrixHasil = new int[matriks[0].length][matriks.length];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length; j++) {
                matrixHasil[j][i] = matriks[i][j];
            }
        }
        System.out.println("Hasil Transpose:");
        displayMatrix(matrixHasil);
    }

    // Menghitung determinan
    private void calculateDeterminant(int[][] matriks) {
        if (matriks.length == matriks[0].length) {
            determinanResult = calculateDeterminantRecursive(matriks);
            System.out.println("Determinan: " + determinanResult);
        } else {
            System.out.println("Matriks harus berbentuk persegi untuk menghitung determinan.");
        }
    }

    // Metode rekursif untuk menghitung determinan
    private double calculateDeterminantRecursive(int[][] matriks) {
        int n = matriks.length;
        double determinan = 0;

        if (n == 1) {
            determinan = matriks[0][0];
        } else if (n == 2) {
            determinan = (matriks[0][0] * matriks[1][1]) - (matriks[0][1] * matriks[1][0]);
        } else {
            for (int i = 0; i < n; i++) {
                int[][] submatrix = createSubmatrix(matriks, i);
                determinan += Math.pow(-1, i) * matriks[0][i] * calculateDeterminantRecursive(submatrix);
            }
        }

        return determinan;
    }

    // Membuat submatriks untuk perhitungan determinan
    private int[][] createSubmatrix(int[][] matriks, int col) {
        int n = matriks.length;
        int[][] submatrix = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            int subCol = 0;
            for (int j = 0; j < n; j++) {
                if (j != col) {
                    submatrix[i - 1][subCol++] = matriks[i][j];
                }
            }
        }
        return submatrix;
    }

    // Menampilkan matriks
    private void displayMatrix(int[][] matriks) {
        for (int[] row : matriks) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Metode untuk menginput elemen-elemen matriks
    private static int[][] inputMatriks(int baris, int kolom, String namaMatriks, Scanner scanner) {
        int[][] matriks = new int[baris][kolom];
        System.out.println("Masukkan elemen-elemen matriks " + namaMatriks + ":");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Masukkan elemen pada posisi (" + (i + 1) + "," + (j + 1) + "): ");
                matriks[i][j] = scanner.nextInt();
            }
        }
        return matriks;
    }

    // Metode utama untuk pengujian
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input untuk matriks pertama
        System.out.print("Masukkan jumlah baris untuk matriks pertama: ");
        int baris1 = scanner.nextInt();
        System.out.print("Masukkan jumlah kolom untuk matriks pertama: ");
        int kolom1 = scanner.nextInt();
        int[][] matriks1 = inputMatriks(baris1, kolom1, "pertama", scanner);

        // Input untuk matriks kedua
        System.out.print("Masukkan jumlah baris untuk matriks kedua: ");
        int baris2 = scanner.nextInt();
        System.out.print("Masukkan jumlah kolom untuk matriks kedua: ");
        int kolom2 = scanner.nextInt();
        int[][] matriks2 = inputMatriks(baris2, kolom2, "kedua", scanner);

        // Membuat objek Matrix dengan matriks yang diinputkan
        new Matrix(matriks1, matriks2);

        // Membuat objek Matrix untuk menghitung transpose
        System.out.println("\nMenghitung Transpose Matriks Pertama:");
        new Matrix(matriks1);

        // Membuat objek Matrix untuk menghitung determinan
        System.out.println("\nMenghitung Determinan Matriks Pertama:");
        new Matrix(matriks1, true);

        scanner.close();
    }
}
