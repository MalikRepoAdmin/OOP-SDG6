package model;

// Konsep Inheritance (Subclass pewarisan murni dari parent User)
public class VerifikasiEmail extends User {
    
    // Konsep Enkapsulasi data dengan modifier private
    private int idVerifikasi;
    private String tanggalKirim;
    private String tanggalVerifikasi;
    private String statusEmail;

    // Constructor murni penampung parameter dinamis
    public VerifikasiEmail(int idUser, String nama, String email, String password, String tanggalLahir, 
                           String pekerjaan, String bio, String domisili, String fotoProfil, 
                           int idVerifikasi, String tanggalKirim, String tanggalVerifikasi, String statusEmail) {
        
        // Melewatkan parameter kredensial login ke constructor parent (User)
        super(idUser, nama, email, password, tanggalLahir, pekerjaan, bio, domisili, fotoProfil);
        
        this.idVerifikasi = idVerifikasi;
        this.tanggalKirim = tanggalKirim;
        this.tanggalVerifikasi = tanggalVerifikasi;
        this.statusEmail = statusEmail;
    }

    // Komponen Enkapsulasi (Getter dan Setter)
    public int getIdVerifikasi() { return idVerifikasi; }
    public void setIdVerifikasi(int idVerifikasi) { this.idVerifikasi = idVerifikasi; }

    public String getTanggalKirim() { return tanggalKirim; }
    public void setTanggalKirim(String tanggalKirim) { this.tanggalKirim = tanggalKirim; }

    public String getTanggalVerifikasi() { return tanggalVerifikasi; }
    public void setTanggalVerifikasi(String tanggalVerifikasi) { this.tanggalVerifikasi = tanggalVerifikasi; }

    public String getStatusEmail() { return statusEmail; }
    public void setStatusEmail(String statusEmail) { this.statusEmail = statusEmail; }
}
