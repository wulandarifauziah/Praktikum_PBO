package models;

// Final class
public final class Admin extends User {
    private String departemen;
    
    public Admin(int idAdmin, String nama, String noTelp, String departemen) {
        super(idAdmin, nama, "Admin", noTelp);
        this.departemen = departemen;
    }
    
    public String getDepartemen() {
        return departemen;
    }
    
    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("ID Admin: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Tipe: " + tipeUser);
        System.out.println("No Telp: " + noTelp);
        System.out.println("Departemen: " + departemen);
        System.out.println("---------------------------------");
    }
}