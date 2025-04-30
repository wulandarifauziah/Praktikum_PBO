package models;

public interface Pembayaran {

    boolean cekPembayaran(String metodePembayaran);

    void prosesPembayaran(double totalHarga, String metodePembayaran);
}
