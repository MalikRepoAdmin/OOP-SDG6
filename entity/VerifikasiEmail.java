package entity;

public class VerifikasiEmail extends User {

    private int idVerifikasi;
    private String tglKirim;
    private String tglVerifikasi;
    private String statusEmail;

    public VerifikasiEmail(int idUser, String nama, String email, String password,
                           String tanggalLahir, String pekerjaan, String bio,
                           String domisili, String fotoProfil,
                           int idVerifikasi, String tglKirim,
                           String tglVerifikasi, String statusEmail) {

        super(idUser, nama, email, password, tanggalLahir,
              pekerjaan, bio, domisili, fotoProfil);

        this.idVerifikasi = idVerifikasi;
        this.tglKirim = tglKirim;
        this.tglVerifikasi = tglVerifikasi;
        this.statusEmail = statusEmail;
    }

    public int getIdVerifikasi() {
        return idVerifikasi;
    }

    public void setIdVerifikasi(int idVerifikasi) {
        this.idVerifikasi = idVerifikasi;
    }

    public String getTglKirim() {
        return tglKirim;
    }

    public void setTglKirim(String tglKirim) {
        this.tglKirim = tglKirim;
    }

    public String getTglVerifikasi() {
        return tglVerifikasi;
    }

    public void setTglVerifikasi(String tglVerifikasi) {
        this.tglVerifikasi = tglVerifikasi;
    }

    public String getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(String statusEmail) {
        this.statusEmail = statusEmail;
    }

    public void tampilkanData() {
        System.out.println("\n=== DATA USER ===");
        System.out.println("ID User        : " + getIdUser());
        System.out.println("Nama           : " + getNama());
        System.out.println("Email          : " + getEmail());

        System.out.println("\n=== VERIFIKASI EMAIL ===");
        System.out.println("ID Verifikasi  : " + idVerifikasi);
        System.out.println("Tanggal Kirim  : " + tglKirim);
        System.out.println("Tanggal Verif  : " + tglVerifikasi);
        System.out.println("Status Email   : " + statusEmail);
    }
}
