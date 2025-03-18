package services;

import models.Obat;
import models.Pelanggan;
import models.ResepDokter;
import models.Transaksi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PelangganService {
    private ArrayList<Obat> daftarObat = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private ArrayList<ResepDokter> daftarResep = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int idPelanggan = 1; // Sementara, nanti bisa disesuaikan dengan sistem login
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
                case 2: beliObat(); break;
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

    private void beliObat() {
        System.out.println("=== BELI OBAT ===");
        lihatObat();
        System.out.print("Masukkan ID Obat yang ingin dibeli: ");
        int idObat = scanner.nextInt();
        scanner.nextLine();

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
        
        System.out.print("Masukkan Nama Anda: ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("Masukkan Usia: ");
        int usia = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan Nomor Telepon: ");
        String noTelp = scanner.nextLine();

        System.out.print("Jumlah yang ingin dibeli: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        if (jumlah > obatDibeli.getStok()) {
            System.out.println("Stok tidak mencukupi.");
            return;
        }

        boolean butuhResep = obatDibeli.isResepDokter();
        if (butuhResep) {
            System.out.println("\n=== Obat ini memerlukan resep dokter. ===");
            System.out.print("Nama Dokter: ");
            String namaDokter = scanner.nextLine();
            System.out.print("Nama Klinik: ");
            String namaKlinik = scanner.nextLine();
            LocalDate tanggalResep = LocalDate.now();
            
            ResepDokter resep = new ResepDokter(idResep++, idPelanggan, idObat, namaDokter, namaKlinik, tanggalResep, false);
            daftarResep.add(resep);
            System.out.println("Resep berhasil diunggah, menunggu verifikasi Admin.");
        } else {
            System.out.println("\nObat ini **tidak** memerlukan resep dokter. Langsung ke pembayaran.");
        }

        System.out.println("\n=== PILIH METODE PEMBAYARAN ===");
        System.out.println("1. Ambil di Apotek");
        System.out.println("2. Transfer");
        System.out.print("Pilih: ");
        int metode = scanner.nextInt();
        scanner.nextLine();

        String metodePembayaran = metode == 1 ? "Ambil di Apotek" : "Transfer";
        double totalHarga = jumlah * obatDibeli.getHarga();
        String statusTransaksi = butuhResep ? "Menunggu Verifikasi Resep" : "Selesai";
        String statusPengambilan = metode == 1 ? "Belum Diambil" : "Selesai";

        Transaksi transaksi = new Transaksi(
            daftarTransaksi.size() + 1, idPelanggan, idObat, jumlah, totalHarga, LocalDate.now(),
            statusTransaksi, metodePembayaran, statusPengambilan, alamat, namaPelanggan, usia, noTelp
            );


        daftarTransaksi.add(transaksi);
        obatDibeli.setStok(obatDibeli.getStok() - jumlah);
        System.out.println("\n✅ Transaksi berhasil dibuat!");
    }

    private void lihatRiwayatTransaksi() {
        System.out.println("\n=== RIWAYAT TRANSAKSI ===");
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.tampilkanTransaksi();
        }
    }
}

