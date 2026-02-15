
public class Sungai {

    int id;
    String nama_sungai, lokasi, status;

    public void setnama(String nama_sungai) {
        this.nama_sungai = nama_sungai;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void getId(int id) {
        this.id = id;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void showdata() {
        System.out.println(
                "ID Sungai : " + id + "\n"
                + "Nama Sungai : " + nama_sungai + "\n"
                + "Lokasi Sungai : " + lokasi + "\n"
                + "Status Sungai : " + status
        );
    }

    public static void main(String[] args) {
        Sungai sungaiobj = new Sungai();

        sungaiobj.setnama("citarum");
        sungaiobj.setLokasi("jawa Barat");
        sungaiobj.getId(1);
        sungaiobj.setStatus("BERSIH");
        sungaiobj.showdata();

    }

}
