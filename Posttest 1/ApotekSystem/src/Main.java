import services.AdminService;
import services.PelangganService;
import models.Obat;
import models.Transaksi;
import models.ResepDokter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Obat> daftarObat = new ArrayList<>();
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
        ArrayList<ResepDokter> daftarResep = new ArrayList<>();

        AdminService adminService = new AdminService(daftarObat, daftarTransaksi, daftarResep, scanner);
        PelangganService pelangganService = new PelangganService(daftarObat, daftarTransaksi, daftarResep, scanner);

        while (true) {
            System.out.println("\n=== SELAMAT DATANG DI APOTEK SEHAT SENTOSA ===");
            System.out.println("1. Admin");
            System.out.println("2. Pelanggan");
            System.out.println("3. Exit");
            System.out.print("Pilih: ");

            int pilihan = inputAngka(scanner);

            switch (pilihan) {
                case 1 -> adminService.menuAdmin();
                case 2 -> pelangganService.menuPelanggan();
                case 3 -> {
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static int inputAngka(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Masukkan harus berupa angka! Coba lagi: ");
            }
        }
    }
}
