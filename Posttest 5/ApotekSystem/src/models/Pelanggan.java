package models;

public class Pelanggan extends User {
    private int usia;
    private String alamat;

    public Pelanggan(int idPelanggan, String nama, int usia, String alamat, String noTelp) {
        super(idPelanggan, nama, "Pelanggan", noTelp);
        this.usia = usia;
        this.alamat = alamat;
    }

    // Getter
    public int getUsia() {
        return usia;
    }

    public String getAlamat() {
        return alamat;
    }

    // Setter
    public void setUsia(int usia) {
        this.usia = usia;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Pelanggan: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Tipe: " + tipeUser);
        System.out.println("Usia: " + usia);
        System.out.println("Alamat: " + alamat);
        System.out.println("No Telp: " + noTelp);
        System.out.println("---------------------------------");
    }
    
    public void tampilkanPelanggan() {
        tampilkanInfo();
    }
}