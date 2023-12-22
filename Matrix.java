import java.util.Scanner;

public class Matrix {

    private int[][] matrixHasil;

    // Konstruktor untuk operasi matriks
    public Matrix(int[][] matriks1, int[][] matriks2) {
        tampilkanMenu();
        lakukanOperasi(matriks1, matriks2);
    }

    // Menampilkan menu
    private void tampilkanMenu() {
        System.out.println("Menu Kalkulator Matriks:");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.print("Pilih operasi (1-4): ");
    }

    // Melakukan operasi matriks yang dipilih
    private void lakukanOperasi(int[][] matriks1, int[][] matriks2) {
        Scanner scanner = new Scanner(System.in);
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                lakukanPenjumlahan(matriks1, matriks2);
                break;
            case 2:
                lakukanPengurangan(matriks1, matriks2);
                break;
            case 3:
                lakukanPerkalian(matriks1, matriks2);
                break;
            case 4:
                lakukanPembagian(matriks1, matriks2);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih angka antara 1 dan 4.");
        }

        scanner.close();
    }

    // Melakukan penjumlahan
    private void lakukanPenjumlahan(int[][] matriks1, int[][] matriks2) {
        if (matriks1.length == matriks2.length && matriks1[0].length == matriks2[0].length) {
            matrixHasil = new int[matriks1.length][matriks1[0].length];
            for (int i = 0; i < matriks1.length; i++) {
                for (int j = 0; j < matriks1[0].length; j++) {
                    matrixHasil[i][j] = matriks1[i][j] + matriks2[i][j];
                }
            }
            System.out.println("Hasil Penjumlahan:");
            tampilkanMatriks(matrixHasil);
        } else {
            System.out.println("Matriks harus memiliki dimensi yang sama untuk penjumlahan.");
        }
    }

    // Melakukan pengurangan
    private void lakukanPengurangan(int[][] matriks1, int[][] matriks2) {
        if (matriks1.length == matriks2.length && matriks1[0].length == matriks2[0].length) {
            matrixHasil = new int[matriks1.length][matriks1[0].length];
            for (int i = 0; i < matriks1.length; i++) {
                for (int j = 0; j < matriks1[0].length; j++) {
                    matrixHasil[i][j] = matriks1[i][j] - matriks2[i][j];
                }
            }
            System.out.println("Hasil Pengurangan:");
            tampilkanMatriks(matrixHasil);
        } else {
            System.out.println("Matriks harus memiliki dimensi yang sama untuk pengurangan.");
        }
    }

    // Melakukan perkalian
    private void lakukanPerkalian(int[][] matriks1, int[][] matriks2) {
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
            tampilkanMatriks(matrixHasil);
        } else {
            System.out.println("Dimensi yang tidak valid untuk perkalian.");
        }
    }

    // Melakukan pembagian
    private void lakukanPembagian(int[][] matriks1, int[][] matriks2) {
        System.out.println("Pembagian matriks tidak didukung dalam versi ini.");
        // Anda dapat mengimplementasikan logika pembagian matriks jika diperlukan
    }

    // Metode untuk menampilkan matriks
    private void tampilkanMatriks(int[][] matriks) {
        for (int[] baris : matriks) {
            for (int nilai : baris) {
                System.out.print(nilai + " ");
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

        scanner.close();
    }
}

