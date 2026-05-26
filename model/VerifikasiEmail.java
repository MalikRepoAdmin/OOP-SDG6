package model;

public class VerifikasiEmail {
    // Enkapsulasi properti data log transaksi murni
    private int idVerifikasi;
    private String tanggalKirim;
    private String tanggalVerifikasi;
    private String statusEmail;
    
    // Relasi Komposisi SRP: Log verifikasi MEMILIKI target satu akun User
    private User targetUser;

    // Constructor pengisian parameter data dan objek relasi
    public VerifikasiEmail(int idVerifikasi, String tanggalKirim, String tanggalVerifikasi, String statusEmail, User targetUser) {
        this.idVerifikasi = idVerifikasi;
        this.tanggalKirim = tanggalKirim;
        this.tanggalVerifikasi = tanggalVerifikasi;
        this.statusEmail = statusEmail;
        this.targetUser = targetUser;
    }

    // Getter dan Setter enkapsulasi data
    public int getIdVerifikasi() { return idVerifikasi; }
    public void setIdVerifikasi(int idVerifikasi) { this.idVerifikasi = idVerifikasi; }

    public String getTanggalKirim() { return tanggalKirim; }
    public void setTanggalKirim(String tanggalKirim) { this.tanggalKirim = tanggalKirim; }

    public String getTanggalVerifikasi() { return tanggalVerifikasi; }
    public void setTanggalVerifikasi(String tanggalVerifikasi) { this.tanggalVerifikasi = tanggalVerifikasi; }

    public String getStatusEmail() { return statusEmail; }
    public void setStatusEmail(String statusEmail) { this.statusEmail = statusEmail; }

    public User getTargetUser() { return targetUser; }
    public void setTargetUser(User targetUser) { this.targetUser = targetUser; }
}
