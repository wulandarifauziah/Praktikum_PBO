package models;

import java.time.LocalDate;

public class ResepDokter {
    private int idResep;
    private int idPelanggan;
    private int idObat;
    private String namaDokter;
    private String namaKlinik;
    private LocalDate tanggalResep;
    private boolean statusVerifikasi; 

    public ResepDokter(int idResep, int idPelanggan, int idObat, String namaDokter, String namaKlinik, LocalDate tanggalResep, boolean statusVerifikasi) {
        this.idResep = idResep;
        this.idPelanggan = idPelanggan;
        this.idObat = idObat;
        this.namaDokter = namaDokter;
        this.namaKlinik = namaKlinik;
        this.tanggalResep = tanggalResep;
        this.statusVerifikasi = statusVerifikasi;
    }

    // Getter
    public int getIdResep() {
        return idResep;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public int getIdObat() {
        return idObat;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getNamaKlinik() {
        return namaKlinik;
    }

    public LocalDate getTanggalResep() {
        return tanggalResep;
    }

    public boolean isStatusVerifikasi() {
        return statusVerifikasi;
    }

    // Setter
    public void setStatusVerifikasi(boolean statusVerifikasi) {
        this.statusVerifikasi = statusVerifikasi;
    }

    // Tampilkan informasi resep dokter
    public void tampilkanResep() {
        System.out.println("ID Resep: " + idResep);
        System.out.println("ID Pelanggan: " + idPelanggan);
        System.out.println("ID Obat: " + idObat);
        System.out.println("Nama Dokter: " + namaDokter);
        System.out.println("Nama Klinik: " + namaKlinik);
        System.out.println("Tanggal Resep: " + tanggalResep);
        System.out.println("Status Resep: " + (statusVerifikasi ? "Disetujui" : "Belum Diverifikasi"));
        System.out.println("---------------------------------");
    }
}
