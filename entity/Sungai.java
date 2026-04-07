package entity;

public class Sungai { // parent class

    private int id;
    private String nama_sungai;
    private String lokasi;
    private String kategori;
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
    public void setNama(String nama_sungai) {
        this.nama_sungai = nama_sungai;
    }

    public String getLokasi(){
        return lokasi;
    }
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKategori() {
        return kategori;
    }
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getStatus() {
        return status;
    }    
    public void setStatus(String status) {
        this.status = status;
    }

}
