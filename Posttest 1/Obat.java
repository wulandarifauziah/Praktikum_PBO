import java.util.ArrayList;

public class Obat {
    private int idObat;
    private String namaObat;
    private double harga;
    private int stok;
    private boolean resepDiperlukan;

    public Obat(int idObat, String namaObat, double harga, int stok, boolean resepDiperlukan) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.harga = harga;
        this.stok = stok;
        this.resepDiperlukan = resepDiperlukan;
    }

    public int getIdObat() { return idObat; }
    public String getNamaObat() { return namaObat; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    public boolean isResepDiperlukan() { return resepDiperlukan; }

    public void setStok(int stok) { this.stok = stok; }

    public void tampilkanDetail() {
        System.out.println("ID: " + idObat + ", Nama: " + namaObat + ", Harga: " + harga +
                ", Stok: " + stok + ", Resep: " + (resepDiperlukan ? "Ya" : "Tidak"));
    }
}
