import java.util.UUID;

class Pelanggan {
    private String id;
    private String nama;
    private int usia;
    private String alamat;
    private String noTelp;

    public Pelanggan(String nama, int usia, String alamat, String noTelp) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nama: " + nama + " | Usia: " + usia + " | Alamat: " + alamat + " | No Telp: " + noTelp;
    }
}
