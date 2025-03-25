package models;

import java.time.LocalDate;

public class Transaksi {
    private int idTransaksi;
    private int idPelanggan;
    private int idObat;
    private int jumlah;
    private double totalHarga;
    private LocalDate tanggal;
    private String statusTransaksi;  
    private String metodePembayaran; 
    private String statusPengambilan; 
    private String alamat;
    private String namaPelanggan;
    private int usia;
    private String noTelp;

    public Transaksi(int idTransaksi, int idPelanggan, int idObat, int jumlah, double totalHarga, LocalDate tanggal, 
                     String statusTransaksi, String metodePembayaran, String statusPengambilan, String alamat, String namaPelanggan, int usia, String noTelp) {
        this.idTransaksi = idTransaksi;
        this.idPelanggan = idPelanggan;
        this.idObat = idObat;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
        this.statusTransaksi = statusTransaksi;
        this.metodePembayaran = metodePembayaran;
        this.statusPengambilan = statusPengambilan;
        this.alamat = alamat;
        this.namaPelanggan = namaPelanggan;
        this.usia = usia;
        this.noTelp = noTelp;
    }

    // Getter
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public int getIdObat() {
        return idObat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getnamaPelanggan() {
        return namaPelanggan;
    }

    public int getusia () {
        return usia;
    }

    public String getnoTelp (){
        return noTelp;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public String getStatusPengambilan() {
        return statusPengambilan;
    }

    // Setter
    public void setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public void setStatusPengambilan(String statusPengambilan) {
        this.statusPengambilan = statusPengambilan;
    }

    // Tampilkan informasi transaksi
    public void tampilkanTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("ID Pelanggan: " + idPelanggan);
        System.out.println("ID Obat: " + idObat);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.println("Tanggal: "  + tanggal);
        System.out.println("Status Transaksi: " + statusTransaksi);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Status Pengambilan: " + statusPengambilan);
        System.out.println("Alamat: " + alamat);
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Usia: " + usia);
        System.out.println("No telepon: " + noTelp);
        System.out.println("---------------------------------");
    }
}
