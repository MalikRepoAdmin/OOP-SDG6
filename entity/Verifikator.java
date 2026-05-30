package entity;

public interface Verifikator {
    
    String ambilNamaPeranSistem();
    
    boolean periksaIzinVerifikasi();
    
    void catatWaktuAktivitasTerakhir(String tanggalDanWaktu);
    
    String ambilWaktuAktivitasTerakhir();
}
