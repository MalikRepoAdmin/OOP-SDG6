package model;

// Memenuhi SRP: Kelas berdiri mandiri khusus mengelola parameter kualitas fisik air
public class StatusSungai {
    // Enkapsulasi data dengan modifier private
    private double indeksPencemaran; 
    private String kondisiFisikAir; 

    // Constructor murni pengisian parameter data status kualitas
    public StatusSungai(double indeksPencemaran, String kondisiFisikAir) {
        this.indeksPencemaran = indeksPencemaran;
        this.kondisiFisikAir = kondisiFisikAir;
    }

    // Metode Getter dan Setter untuk pembatasan hak akses variabel
    public double getIndeksPencemaran() { return indeksPencemaran; }
    public void setIndeksPencemaran(double indeksPencemaran) { this.indeksPencemaran = indeksPencemaran; }

    public String getKondisiFisikAir() { return kondisiFisikAir; }
    public void setKondisiFisikAir(String kondisiFisikAir) { this.kondisiFisikAir = kondisiFisikAir; }
}
