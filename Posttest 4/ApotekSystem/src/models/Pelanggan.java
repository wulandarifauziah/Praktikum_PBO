package models;

public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private int usia;
    private String alamat;
    private String noTelp;

    public Pelanggan(int idPelanggan, String nama, int usia, String alamat, String noTelp) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    // Getter
    public int getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    // Tampilkan informasi pelanggan
    public void tampilkanPelanggan() {
        System.out.println("ID Pelanggan: " + idPelanggan);
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia);
        System.out.println("Alamat: " + alamat);
        System.out.println("No Telp: " + noTelp);
        System.out.println("---------------------------------");
    }
}

