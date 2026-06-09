package entity;

public class UserVerifikasiEmail extends User {

    private String statusVerifikasi;

    public UserVerifikasiEmail(int idUser, String username, String email, String statusVerifikasi) {
        super(idUser, username, email);
        this.statusVerifikasi = statusVerifikasi;
    }

    public String getStatusVerifikasi() {
        return statusVerifikasi;
    }

    public void setStatusVerifikasi(String statusVerifikasi) {
        this.statusVerifikasi = statusVerifikasi;
    }

    // POLIMORFISME (override)
    @Override
    public String toString() {
        return super.toString() + " | Status Verifikasi: " + statusVerifikasi;
    }
}