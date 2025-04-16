package services;

import models.Obat;
import models.Transaksi;
import models.ResepDokter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

public class AdminService {
    private ArrayList<Obat> daftarObat;
    private ArrayList<Transaksi> daftarTransaksi;
    private ArrayList<ResepDokter> daftarResep;
    private Scanner scanner;

    public AdminService(ArrayList<Obat> daftarObat, ArrayList<Transaksi> daftarTransaksi, ArrayList<ResepDokter> daftarResep, Scanner scanner) {
        this.daftarObat = daftarObat;
        this.daftarTransaksi = daftarTransaksi;
        this.daftarResep = daftarResep;
        this.scanner = scanner;
    }

    public void menuAdmin() {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah Obat");
            System.out.println("2. Lihat Obat");
            System.out.println("3. Update Obat");
            System.out.println("4. Hapus Obat");
            System.out.println("5. Lihat Transaksi");
            System.out.println("6. Verifikasi Resep");
            System.out.println("7. Logout");
            System.out.print("Pilih: ");

            int pilihan = inputAngka();
            switch (pilihan) {
                case 1 -> tambahObat();
                case 2 -> lihatObat();
                case 3 -> updateObat();
                case 4 -> hapusObat();
                case 5 -> lihatTransaksi();
                case 6 -> verifikasiResep();
                case 7 -> {
                    System.out.println("Logout berhasil!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tambahObat() {
        System.out.print("ID Obat: ");
        int id = inputAngka();

        System.out.print("Nama Obat: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = inputDouble();
        System.out.print("Stok: ");
        int stok = inputAngka();

        System.out.print("Obat membutuhkan resep? (ya/tidak): ");
        boolean butuhResep = scanner.nextLine().trim().equalsIgnoreCase("ya");

        daftarObat.add(new Obat(id, nama, harga, stok, butuhResep));
        System.out.println("Obat berhasil ditambahkan.");
    }

    public void lihatObat() {
          if (daftarObat.isEmpty()) {
            System.out.println("Tidak ada obat yang tersedia.");
            return;
        }

        System.out.println("\n=== DAFTAR OBAT ===");
        for (Obat obat : daftarObat) {
            obat.tampilkanObat();
        }
    }

    private void updateObat() {
        System.out.println("\n=========== Update Obat ==============");
        lihatObat();
        System.out.print("Masukkan ID Obat yang ingin diupdate: ");
        int id = inputAngka();
        for (Obat obat : daftarObat) { 
            if (obat.getIdObat() == id) {
                System.out.print("Nama Baru: ");
                String nama = scanner.nextLine();
                System.out.print("Harga Baru: ");
                double harga = inputDouble();
                System.out.print("Tambahkan Stok: ");
                int tambahanStok = inputAngka();
    
                obat.setNamaObat(nama);
                obat.setHarga(harga);
                obat.setStok(obat.getStok() + tambahanStok);
    
                System.out.println("Obat berhasil diupdate.");
                return; 
            }
        }
        System.out.println("Obat tidak ditemukan.");
    }
    
    private void hapusObat() {
        System.out.println("\n=========== Hapus Obat ==============");
        lihatObat();
        System.out.print("Masukkan ID Obat yang ingin dihapus: ");
        int id = inputAngka();

        if (daftarObat.removeIf(obat -> obat.getIdObat() == id)) {
            System.out.println("Obat berhasil dihapus.");
        } else {
            System.out.println("Obat tidak ditemukan.");
        }
    }

    private void lihatTransaksi() {
        
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n=== DAFTAR TRANSAKSI ===");
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.tampilkanTransaksi();
        }
    }

    private void verifikasiResep() {
        if (daftarResep.isEmpty()) {
            System.out.println("Tidak ada resep yang perlu diverifikasi.");
            return;
        }
    
        System.out.println("\n=== DAFTAR RESEP MENUNGGU VERIFIKASI ===");
        Iterator<ResepDokter> iterator = daftarResep.iterator();
        while (iterator.hasNext()) {
            ResepDokter resep = iterator.next();
            if (!resep.isStatusVerifikasi()) {
                resep.tampilkanResep();
                System.out.print("Setujui resep ini? (y/n): ");
                String keputusan = scanner.nextLine();
                if (keputusan.equalsIgnoreCase("y")) {
                    resep.setStatusVerifikasi(true);
                    perbaruiStatusTransaksi(resep, "Terverifikasi");
                    System.out.println("Resep berhasil diverifikasi.");
                } else {
                    System.out.println("Resep tidak disetujui. Menghapus dari daftar verifikasi.");
                    iterator.remove();
                    perbaruiStatusTransaksi(resep, "Resep Ditolak");
                }
            }
        }
    }
    
    private void perbaruiStatusTransaksi(ResepDokter resep, String statusBaru) {
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getIdObat() == resep.getIdObat() && transaksi.getIdPelanggan() == resep.getIdPelanggan()
                    && transaksi.getStatusTransaksi().equals("Menunggu Verifikasi Resep")) {
                transaksi.setStatusTransaksi(statusBaru);
            }
        }
    }
    
    private int inputAngka() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan harus berupa angka! Coba lagi.");
            }
        }
    }

    private double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Masukkan harus berupa angka! Coba lagi: ");
            }
        }
    }
    // Overloaded method tambahObat (Polymorphism)
public void tambahObat(int id, String nama, double harga, int stok, boolean butuhResep) {
    daftarObat.add(new Obat(id, nama, harga, stok, butuhResep));
    System.out.println("Obat berhasil ditambahkan (dari method overload).");
}


}
