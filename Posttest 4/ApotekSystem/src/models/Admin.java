package models;

public class Admin {
    private int idAdmin;
    private String nama;
    private String noTelp;

    public Admin(int idAdmin, String nama, String noTelp) {
        this.idAdmin = idAdmin;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    // Getter
    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    // Tampilkan informasi admin
    public void tampilkanAdmin() {
        System.out.println("ID Admin: " + idAdmin);
        System.out.println("Nama: " + nama);
        System.out.println("No Telp: " + noTelp);
    }
}
