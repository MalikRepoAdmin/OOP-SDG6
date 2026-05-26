package entity;

public interface DokumenPemantauan {
    
    String ambilKodeUnikDokumen();
    
    String ambilTanggalPencatatan();
    
    String ambilStatusValidasiAkhir();
    
    boolean periksaKelayakanBerkas();
}
