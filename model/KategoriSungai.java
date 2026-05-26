package model;

// Memenuhi SRP: Kelas berdiri mandiri khusus mengelola standarisasi tingkatan keamanan air
public class KategoriSungai {
    // Enkapsulasi data dengan modifier private
    private String tingkatanKeamanan; 
    private String deskripsiKelayakan;

    // Constructor murni pengisian parameter data kategori
    public KategoriSungai(String tingkatanKeamanan, String deskripsiKelayakan) {
        this.tingkatanKeamanan = tingkatanKeamanan;
        this.deskripsiKelayakan = deskripsiKelayakan;
    }

    // Metode Getter dan Setter untuk pembatasan hak akses variabel
    public String getTingkatanKeamanan() { return tingkatanKeamanan; }
    public void setTingkatanKeamanan(String tingkatanKeamanan) { this.tingkatanKeamanan = tingkatanKeamanan; }

    public String getDeskripsiKelayakan() { return deskripsiKelayakan; }
    public void setDeskripsiKelayakan(String deskripsiKelayakan) { this.deskripsiKelayakan = deskripsiKelayakan; }
}
