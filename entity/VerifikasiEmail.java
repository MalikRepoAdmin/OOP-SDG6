package entity;

public class VerifikasiEmail extends User {
    public int idVerifikasi;
    public String tglKirim;
    public String tglVerifikasi;
    public String statusEmail;

    // Constructor
    public VerifikasiEmail(
                           int idVerifikasi, String tglKirim, String tglVerifikasi, String statusEmail) {
        this.idVerifikasi = idVerifikasi;
        this.tglKirim = tglKirim;
        this.tglVerifikasi = tglVerifikasi;
        this.statusEmail = statusEmail;
    }

    // Getter & Setter (opsional)
    public int getIdVerifikasi() { return idVerifikasi; }
    public void setIdVerifikasi(int idVerifikasi) { this.idVerifikasi = idVerifikasi; }

    public String getTglKirim() { return tglKirim; }
    public void setTglKirim(String tglKirim) { this.tglKirim = tglKirim; }

    public String getTglVerifikasi() { return tglVerifikasi; }
    public void setTglVerifikasi(String tglVerifikasi) { this.tglVerifikasi = tglVerifikasi; }

    public String getStatusEmail() { return statusEmail; }
    public void setStatusEmail(String statusEmail) { this.statusEmail = statusEmail; }

    // Method tampilkan data
    public void tampilkanData() {
        System.out.println("\n\nID Verifikasi  : " + idVerifikasi);
        System.out.println("Tanggal Kirim  : " + tglKirim);
        System.out.println("Tanggal Verif  : " + tglVerifikasi);
        System.out.println("Status Email   : " + statusEmail);
    }
}