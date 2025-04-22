package models;

// Abstract class --> parent class
public abstract class User {
    protected int id;
    protected String nama;
    // Final attribute
    protected final String tipeUser;
    protected String noTelp;
    
    public User(int id, String nama, String tipeUser, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.tipeUser = tipeUser;
        this.noTelp = noTelp;
    }
    
    // Getter
    public int getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getTipeUser() {
        return tipeUser;
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
     
    public abstract void tampilkanInfo();
    
    public final String getIdentitas() {
        return "ID: " + id + ", Nama: " + nama + ", Tipe: " + tipeUser;
    }
}
