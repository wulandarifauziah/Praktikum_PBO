package services;

import models.Pembayaran;
import java.util.Arrays;
import java.util.List;

public class PembayaranService implements Pembayaran {
    private static final List<String> METODE_PEMBAYARAN_TERSEDIA = Arrays.asList(
        "Ambil di Apotek", 
        "Transfer", 
        "QRIS", 
        "Kartu Kredit"
    );
    
    private static double BIAYA_ADMIN = 2000.0;
    
    public static List<String> getMetodePembayaranTersedia() {
        return METODE_PEMBAYARAN_TERSEDIA;
    }
    
    public static void setBiayaAdmin(double biayaBaru) {
        if (biayaBaru >= 0) {
            BIAYA_ADMIN = biayaBaru;
        }
    }
    
    public static double getBiayaAdmin() {
        return BIAYA_ADMIN;
    }
    
    @Override
    public boolean cekPembayaran(String metodePembayaran) {
        return METODE_PEMBAYARAN_TERSEDIA.contains(metodePembayaran);
    }
    
    @Override
    public void prosesPembayaran(double totalHarga, String metodePembayaran) {
        if (!cekPembayaran(metodePembayaran)) {
            throw new IllegalArgumentException("Metode pembayaran tidak tersedia: " + metodePembayaran);
        }
        
        double biayaFinal = totalHarga;
        
        if (!metodePembayaran.equals("Ambil di Apotek")) {
            biayaFinal += BIAYA_ADMIN;
        }
        
        System.out.println("Memproses pembayaran sebesar Rp " + biayaFinal + " dengan metode " + metodePembayaran);
        System.out.println("Pembayaran berhasil!");
    }
}