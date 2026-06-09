package entity;

public class SungaiMonitoring extends Sungai {
    private double phAir;

    // Tambahkan parameter Kategori dan Status ke constructor ini
    public SungaiMonitoring(int id, String nama, String lokasi, KategoriSungai kat, StatusSungai stat, double phAir) {
        super(id, nama, lokasi, kat, stat); 
        this.phAir = phAir;
    }

    public double getPhAir() { return phAir; }
    public void setPhAir(double phAir) { this.phAir = phAir; }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail(); 
        System.out.println("Status pH Air: " + phAir);
    }
}