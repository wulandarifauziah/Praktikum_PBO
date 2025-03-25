import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApotekManager apotek = new ApotekManager();
        Scanner input = new Scanner(System.in);
        
        // Tambah beberapa data awal
        apotek.tambahObat(new Obat(1, "Paracetamol", 5000, 20, false));
        apotek.tambahObat(new Obat(2, "Amoxicillin", 10000, 15, true));

        while (true) {
            System.out.println("\n=== SISTEM APOTEK ===");
            System.out.println("1. Admin");
            System.out.println("2. Pelanggan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();

            if (pilihan == 1) { // Menu Admin
                while (true) {
                    System.out.println("\n=== MENU ADMIN ===");
                    System.out.println("1. Kelola Stok Obat");
                    System.out.println("2. Lihat Transaksi");
                    System.out.println("3. Verifikasi Resep");
                    System.out.println("4. Kembali");
                    System.out.print("Pilihan: ");
                    int pilihAdmin = input.nextInt();

                    if (pilihAdmin == 1) {
                        apotek.tampilkanObat();
                    } else if (pilihAdmin == 2) {
                        apotek.tampilkanTransaksi();
                    } else if (pilihAdmin == 3) {
                        apotek.tampilkanResep();
                    } else break;
                }
            } 
            else if (pilihan == 2) { // Menu Pelanggan
                System.out.println("\n=== MENU PELANGGAN ===");
                apotek.tampilkanObat();
            } 
            else break;
        }
        
        input.close();
        System.out.println("Terima kasih telah menggunakan sistem apotek!");
    }
}
