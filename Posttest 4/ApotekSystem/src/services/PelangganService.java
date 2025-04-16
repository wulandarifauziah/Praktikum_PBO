package services;

import models.Obat;
import models.Pelanggan;
import models.ResepDokter;
import models.Transaksi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PelangganService {
    // Menggunakan private untuk menerapkan Encapsulation
    private ArrayList<Obat> daftarObat = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private ArrayList<ResepDokter> daftarResep = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int idPelanggan = 1;
    private int idResep = 1;

    public PelangganService(ArrayList<Obat> daftarObat, ArrayList<Transaksi> daftarTransaksi, ArrayList<ResepDokter> daftarResep, Scanner scanner) {
        this.daftarObat = daftarObat;
        this.daftarTransaksi = daftarTransaksi;
        this.daftarResep = daftarResep;
        this.scanner = scanner;
    }

    public void menuPelanggan() {
        while (true) {
            System.out.println("\n=== MENU PELANGGAN ===");
            System.out.println("1. Lihat Obat");
            System.out.println("2. Beli Obat");
            System.out.println("3. Lihat Riwayat Transaksi");
            System.out.println("4. Logout");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: lihatObat(); break;
                case 2: beliObatMenu(); break;
                case 3: lihatRiwayatTransaksi(); break;
                case 4: return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void lihatObat() {
        System.out.println("\n=== DAFTAR OBAT ===");
        for (Obat obat : daftarObat) {
            obat.tampilkanObat();
        }
    }

    private int inputUsia() {
        while (true) {
            try {
                System.out.print("Masukkan Usia: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Usia harus berupa angka. Silakan coba lagi.");
            }
        }
    }

    // Menu Beli Obat dengan opsi resep atau tanpa resep
    private void beliObatMenu() {
        System.out.print("Masukkan Nama: ");
        String namaPelanggan = scanner.nextLine();
        int usia = inputUsia();
        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan No. Telepon: ");
        String noTelp = scanner.nextLine();
        System.out.print("Masukkan ID Obat: ");
        int idObat = scanner.nextInt();
        System.out.print("Masukkan Jumlah: ");
        int jumlah = scanner.nextInt();

        System.out.print("Apakah ada resep? (y/n): ");
        char resepOption = scanner.next().charAt(0);

        if (resepOption == 'y' || resepOption == 'Y') {
            scanner.nextLine();
            System.out.print("Masukkan Nama Dokter: ");
            String namaDokter = scanner.nextLine();
            System.out.print("Masukkan Nama Klinik: ");
            String namaKlinik = scanner.nextLine();
            // Panggil beliObat dengan resep
            beliObat(namaPelanggan, usia, alamat, noTelp, idObat, jumlah, namaDokter, namaKlinik);
        } else {
            // Jika tidak ada resep, panggil beliObat tanpa resep
            beliObat(namaPelanggan, usia, alamat, noTelp, idObat, jumlah);
        }
    }

    // Overloaded method beliObat (tanpa resep)
    protected void beliObat(String namaPelanggan, int usia, String alamat, String noTelp, int idObat, int jumlah) {
        Obat obatDibeli = null;
        for (Obat obat : daftarObat) {
            if (obat.getIdObat() == idObat) {
                obatDibeli = obat;
                break;
            }
        }

        if (obatDibeli == null) {
            System.out.println("Obat tidak ditemukan!");
            return;
        }

        if (jumlah > obatDibeli.getStok()) {
            System.out.println("Stok tidak mencukupi.");
            return;
        }

        double totalHarga = jumlah * obatDibeli.getHarga();
        Transaksi transaksi = new Transaksi(
            daftarTransaksi.size() + 1, idPelanggan, idObat, jumlah, totalHarga, LocalDate.now(),
            "Selesai", "Transfer", "Selesai", alamat, namaPelanggan, usia, noTelp
        );

        daftarTransaksi.add(transaksi);
        obatDibeli.setStok(obatDibeli.getStok() - jumlah);
        System.out.println("\nTransaksi berhasil dibuat!");
    }

    // Overloaded method beliObat (dengan resep)
    protected void beliObat(String namaPelanggan, int usia, String alamat, String noTelp, int idObat, int jumlah, String namaDokter, String namaKlinik) {
        Obat obatDibeli = null;
        for (Obat obat : daftarObat) {
            if (obat.getIdObat() == idObat) {
                obatDibeli = obat;
                break;
            }
        }

        if (obatDibeli == null) {
            System.out.println("Obat tidak ditemukan!");
            return;
        }

        if (jumlah > obatDibeli.getStok()) {
            System.out.println("Stok tidak mencukupi.");
            return;
        }

        LocalDate tanggalResep = LocalDate.now();
        ResepDokter resep = new ResepDokter(idResep++, idPelanggan, idObat, namaDokter, namaKlinik, tanggalResep, false);
        daftarResep.add(resep);
        System.out.println("Resep berhasil diunggah, menunggu verifikasi Admin.");

        double totalHarga = jumlah * obatDibeli.getHarga();
        Transaksi transaksi = new Transaksi(
            daftarTransaksi.size() + 1, idPelanggan, idObat, jumlah, totalHarga, LocalDate.now(),
            "Menunggu Verifikasi Resep", "Transfer", "Belum Diambil", alamat, namaPelanggan, usia, noTelp
        );

        daftarTransaksi.add(transaksi);
        obatDibeli.setStok(obatDibeli.getStok() - jumlah);
        System.out.println("\nTransaksi berhasil dibuat!");
    }

    // Getter
    public ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    // Setter
    public void setDaftarTransaksi(ArrayList<Transaksi> daftarTransaksi) {
        this.daftarTransaksi = daftarTransaksi;
    }

    private void lihatRiwayatTransaksi() {
        System.out.println("\n=== RIWAYAT TRANSAKSI ===");
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.tampilkanTransaksi();
        }
    }
}
