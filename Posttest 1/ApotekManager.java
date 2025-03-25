public void beliObat(int idObat, int jumlah, String metodePembayaran) {
    for (Obat o : daftarObat) {
        if (o.getIdObat() == idObat) {
            if (o.getStok() >= jumlah) {
                Transaksi transaksi = new Transaksi(daftarTransaksi.size() + 1, 1, o, jumlah, metodePembayaran);
                daftarTransaksi.add(transaksi);
                o.setStok(o.getStok() - jumlah);
                System.out.println("Pembelian berhasil! Transaksi ID: " + transaksi.getIdTransaksi());
            } else {
                System.out.println("Stok tidak mencukupi!");
            }
            return;
        }
    }
    System.out.println("Obat tidak ditemukan.");
}

public void unggahResep(int idObat, String namaDokter) {
    for (Obat o : daftarObat) {
        if (o.getIdObat() == idObat && o.isResepDiperlukan()) {
            ResepDokter resep = new ResepDokter(daftarResep.size() + 1, 1, o, namaDokter);
            daftarResep.add(resep);
            System.out.println("Resep berhasil diunggah dan menunggu verifikasi.");
            return;
        }
    }
    System.out.println("Obat ini tidak memerlukan resep atau tidak ditemukan.");
}
