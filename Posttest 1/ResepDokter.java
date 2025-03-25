public class ResepDokter {
    private int idResep;
    private int idPelanggan;
    private Obat obat;
    private String namaDokter;
    private boolean statusVerifikasi;

    public ResepDokter(int idResep, int idPelanggan, Obat obat, String namaDokter) {
        this.idResep = idResep;
        this.idPelanggan = idPelanggan;
        this.obat = obat;
        this.namaDokter = namaDokter;
        this.statusVerifikasi = false;
    }

    public void verifikasiResep() {
        this.statusVerifikasi = true;
        System.out.println("Resep untuk obat " + obat.getNamaObat() + " telah diverifikasi.");
    }

    public void tampilkanDetail() {
        System.out.println("ID Resep: " + idResep + ", Pasien: " + idPelanggan + 
                ", Obat: " + obat.getNamaObat() + ", Dokter: " + namaDokter +
                ", Status: " + (statusVerifikasi ? "Terverifikasi" : "Belum Diverifikasi"));
    }
}
