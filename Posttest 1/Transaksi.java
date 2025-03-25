public class Transaksi {
    private int idTransaksi;
    private int idPelanggan;
    private Obat obat;
    private int jumlah;
    private double totalHarga;
    private String metodePembayaran;
    private boolean statusTransaksi;

    public Transaksi(int idTransaksi, int idPelanggan, Obat obat, int jumlah, String metodePembayaran) {
        this.idTransaksi = idTransaksi;
        this.idPelanggan = idPelanggan;
        this.obat = obat;
        this.jumlah = jumlah;
        this.totalHarga = jumlah * obat.getHarga();
        this.metodePembayaran = metodePembayaran;
        this.statusTransaksi = false; // Belum diproses
    }

    public int getIdTransaksi() { return idTransaksi; }
    public void setStatusTransaksi(boolean status) { this.statusTransaksi = status; }

    public void tampilkanDetail() {
        System.out.println("ID Transaksi: " + idTransaksi + ", Pelanggan: " + idPelanggan +
                ", Obat: " + obat.getNamaObat() + ", Jumlah: " + jumlah + ", Total: " + totalHarga +
                ", Pembayaran: " + metodePembayaran + ", Status: " + (statusTransaksi ? "Selesai" : "Pending"));
    }
}
