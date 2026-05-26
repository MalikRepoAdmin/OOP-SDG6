package entity;

public class Admin extends User implements Verifikator {
    private String idAdmin;
    private String logWaktuAktivitas;

    public Admin(int idUser, String nama, String email, String password, String idAdmin) {
        super(idUser, nama, email, password, "-", "-", "-", "-", "-");
        this.idAdmin = idAdmin;
        this.logWaktuAktivitas = "Belum ada aktivitas"; // Status awal bawaan
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String ambilNamaPeranSistem() {
        return "ADMIN_VERIFIKATOR_UTAMA";
    }

    @Override
    public boolean periksaIzinVerifikasi() {
        return true; 
    }

    @Override
    public void catatWaktuAktivitasTerakhir(String tanggalDanWaktu) {
        this.logWaktuAktivitas = tanggalDanWaktu;
    }

    @Override
    public String ambilWaktuAktivitasTerakhir() {
        return this.logWaktuAktivitas;
    }
}
