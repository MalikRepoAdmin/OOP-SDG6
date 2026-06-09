class VerifikasiEmailSungai extends UserService {

    private String statusVerifikasi; 

    public VerifikasiEmailSungai(String username, String email, String statusVerifikasi) {
        super(username, email);
        this.statusVerifikasi = statusVerifikasi;
    }

    public String getStatusVerifikasi() {
        return statusVerifikasi;
    }

    public void setStatusVerifikasi(String statusVerifikasi) {
        this.statusVerifikasi = statusVerifikasi;
    }

    @Override
    public String tampilkanDetail() {
        return super.tampilkanDetail() + " | Status: " + statusVerifikasi;
    }
}