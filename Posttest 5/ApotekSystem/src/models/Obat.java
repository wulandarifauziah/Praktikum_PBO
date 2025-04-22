package models;

import java.text.DecimalFormat;

public class Obat {
    private int idObat;
    private String namaObat;
    private double harga;
    private int stok;
    private boolean resepDokter; // true jika butuh resep, false jika tidak

    public Obat(int idObat, String namaObat, double harga, int stok, boolean resepDokter) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.harga = Math.max(harga, 0); 
        this.stok = Math.max(stok, 0);   
        this.resepDokter = resepDokter;
    }

    // Getter
    public int getIdObat() {
        return idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public boolean isResepDokter() {
        return resepDokter;
    }

    // Setter
    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        }
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

    public void setResepDokter(boolean resepDokter) {
        this.resepDokter = resepDokter;
    }

    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
        }
    }

    public void kurangiStok(int jumlah) {
        if (jumlah > 0 && this.stok >= jumlah) {
            this.stok -= jumlah;
        }
    }

    @Override
    public String toString() {
        DecimalFormat rupiahFormat = new DecimalFormat("#,###.00");
        return "Obat{" +
               "ID=" + idObat +
               ", Nama='" + namaObat + '\'' +
               ", Harga=Rp " + rupiahFormat.format(harga) +
               ", Stok=" + stok +
               ", Butuh Resep=" + (resepDokter ? "Ya" : "Tidak") +
               '}';
    }

    // Modifikasi tampilan obat agar lebih rapi per baris
    public void tampilkanObat() {
        DecimalFormat rupiahFormat = new DecimalFormat("#,###.00");
        System.out.println("---------------------------------");
        System.out.println("ID Obat      : " + idObat);
        System.out.println("Nama Obat    : " + namaObat);
        System.out.println("Harga        : Rp " + rupiahFormat.format(harga));
        System.out.println("Stok         : " + stok);
        System.out.println("Butuh Resep  : " + (resepDokter ? "Ya" : "Tidak"));
        System.out.println("---------------------------------");
    }
}