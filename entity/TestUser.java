public class TestUser {
    public static void main(String[] args) {

        VerifikasiEmail vrf = new VerifikasiEmail(
            1,                          
            "Angelis Nasta Nadia",             
            "angel@email.com",           
            "123456",                   
            101,                        
            "2026-03-01",               
            "2026-03-02",               
            "TERVERIFIKASI"             
        );

        vrf.tampilkanData();
    }
}

class User {
    public int idUser;
    public String nama;
    public String email;
    public String password;

    // Constructor
    public User(int idUser, String nama, String email, String password) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    // Method tampilkan data
    public void tampilkanData() {
        System.out.println("ID User     : " + idUser);
        System.out.println("Nama        : " + nama);
        System.out.println("Email       : " + email);
        System.out.println("Password    : " + password);
    }
}

class VerifikasiEmail extends User {
    public int idVerifikasi;
    public String tglKirim;
    public String tglVerifikasi;
    public String statusEmail;

    // Constructor
    public VerifikasiEmail(int idUser, String nama, String email, String password,
                           int idVerifikasi, String tglKirim, String tglVerifikasi, String statusEmail) {
        super(idUser, nama, email, password);
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
    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("ID Verifikasi  : " + idVerifikasi);
        System.out.println("Tanggal Kirim  : " + tglKirim);
        System.out.println("Tanggal Verif  : " + tglVerifikasi);
        System.out.println("Status Email   : " + statusEmail);
    }
}