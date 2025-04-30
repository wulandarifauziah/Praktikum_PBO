import services.AdminService;
import services.PelangganService;
import services.PembayaranService;
import models.Obat;
import models.Transaksi;
import models.ResepDokter;
import models.Admin;
import models.Pelanggan;
import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String APP_VERSION = "1.0.0";
    public static final String APP_NAME = "APOTEK SEHAT SENTOSA";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Obat> daftarObat = new ArrayList<>();
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
        ArrayList<ResepDokter> daftarResep = new ArrayList<>();
        ArrayList<User> daftarUser = new ArrayList<>();
        
        Admin admin = new Admin(1, "AdminDefault", "081234567890", "Farmasi");
        daftarUser.add(admin);

        PembayaranService.setBiayaAdmin(2500.0);
        
        tampilkanInfoAplikasi();

        AdminService adminService = new AdminService(daftarObat, daftarTransaksi, daftarResep, scanner);
        PelangganService pelangganService = new PelangganService(daftarObat, daftarTransaksi, daftarResep, scanner);
        
        while (true) {
            try {
                tampilkanMenuUtama();
                System.out.print("Pilih: ");
                int pilihan = inputAngka(scanner);
                
                switch (pilihan) {
                    case 1:
                        adminService.menuAdmin();
                        break;
                    case 2:
                        pelangganService.menuPelanggan();
                        break;
                    case 3:
                        System.out.println("Terima kasih! Program selesai.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    public static void tampilkanMenuUtama() {
        System.out.println("\n=== SELAMAT DATANG DI " + APP_NAME + " ===");
        System.out.println("1. Admin");
        System.out.println("2. Pelanggan");
        System.out.println("3. Exit");
    }
    
    public static void tampilkanInfoAplikasi() {
        System.out.println("======================================");
        System.out.println("      " + APP_NAME);
        System.out.println("      Version: " + APP_VERSION);
        System.out.println("======================================");
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