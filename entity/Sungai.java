package entity;

public class Sungai { // parent class

    private int id;
    private String nama_sungai;
    private String lokasi;
    private String ketegori;
    private String status;

   //getter&setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama(){
        return nama_sungai;
    }
    public String setNama(String nama_sungai) {
        return this.nama_sungai = nama_sungai;
    }

    public String getLokasi(){
        return lokasi;
    }
    public String setLokasi(String lokasi) {
        return this.lokasi = lokasi;
    }

    public String getKategori() {
        return ketegori;
    }
    public String setKategori(String ketegori) {
        return this.ketegori = ketegori;
    }

    public String getStatus() {
        return status;
    }    
    public String setStatus(String status) {
        return this.status = status;
    }

}
