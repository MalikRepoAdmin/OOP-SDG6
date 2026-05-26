package entity;

public class Laporan implements DokumenPemantauan {
    private String idLaporan;
    private String tanggalPemantauan;
    private String hasilKondisiAir;
    private String statusVerifikasi;
    
    // Relasi Objek Murni (Menghubungkan Laporan dengan data Sungai)
    private KategoriSungai kategoriSungai;
    private StatusSungai statusSungai;

    // Constructor murni menerima objek kategori dan status sungai secara dinamis dari luar
    public Laporan(String idLaporan, String tanggalPemantauan, String hasilKondisiAir, 
                   String statusVerifikasi, KategoriSungai kategoriSungai, StatusSungai statusSungai) {
        this.idLaporan = idLaporan;
        this.tanggalPemantauan = tanggalPemantauan;
        this.hasilKondisiAir = hasilKondisiAir;
        this.statusVerifikasi = statusVerifikasi;
        this.kategoriSungai = kategoriSungai;
        this.statusSungai = statusSungai;
    }

    // ==========================================
    // GETTER & SETTER UNTUK DATA SUNGAI DI LAPORAN
    // ==========================================
    public KategoriSungai getKategoriSungai() {
        return kategoriSungai;
    }

    public void setKategoriSungai(KategoriSungai kategoriSungai) {
        this.kategoriSungai = kategoriSungai;
    }

    public StatusSungai getStatusSungai() {
        return statusSungai;
    }

    public void setStatusSungai(StatusSungai statusSungai) {
        this.statusSungai = statusSungai;
    }

    // Properti getter-setter Laporan lainnya tetap sama...
    @Override
    public String ambilKodeUnikDokumen() { return this.idLaporan; }
    @Override
    public String ambilTanggalPencatatan() { return this.tanggalPemantauan; }
    @Override
    public String ambilStatusValidasiAkhir() { return this.statusVerifikasi; }
    @Override
    public boolean periksaKelayakanBerkas() {
        return this.idLaporan != null && this.kategoriSungai != null && this.statusSungai != null;
    }
}
