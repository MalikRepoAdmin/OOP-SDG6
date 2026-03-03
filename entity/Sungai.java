package entity;

public class Sungai { // parent class

    int id;
    String nama_sungai, lokasi;

    public void setNama(String nama_sungai) {
        this.nama_sungai = nama_sungai;
        System.out.println("Nama Sungai : " + nama_sungai);
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("ID Sungai : " + id);
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
        System.out.println("Lokasi Sungai : " + lokasi);
    }

    public void kategori(String kategori) {
    }

    public void setStatus(String status) {
    }

}
