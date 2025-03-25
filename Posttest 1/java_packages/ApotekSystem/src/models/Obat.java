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
        this.harga = harga;
        this.stok = stok;
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
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setResepDokter(boolean resepDokter) {
        this.resepDokter = resepDokter;
    }

    // Tampilkan informasi obat
    public void tampilkanObat() {
        DecimalFormat rupiahFormat = new DecimalFormat("#,###.00");
        
        System.out.println("ID Obat: " + idObat);
        System.out.println("Nama Obat: " + namaObat);
        System.out.println("Harga: Rp " + rupiahFormat.format(harga));
        System.out.println("Stok: " + stok);
        System.out.println("Memerlukan Resep Dokter: " + (resepDokter ? "Ya" : "Tidak"));
        System.out.println("---------------------------------");
    }
}
