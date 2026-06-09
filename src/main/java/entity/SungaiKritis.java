package entity;

public class SungaiKritis extends Sungai {
    private double persentaseAreaTerancam;

    public SungaiKritis(int id,
                       String namaSungai,
                       String lokasi,
                       KategoriSungai komponenKategori,
                       StatusSungai komponenStatus,
                       double persentaseAreaTerancam) {
        super(id, namaSungai, lokasi, komponenKategori, komponenStatus);
        this.persentaseAreaTerancam = persentaseAreaTerancam;
    }

    public double getPersentaseAreaTerancam() {
        return persentaseAreaTerancam;
    }	

    public void setPersentaseAreaTerancam(double persentaseAreaTerancam) {
        this.persentaseAreaTerancam = persentaseAreaTerancam;
    }

    @Override
    public String tampilkanDetail() {
        return "Sungai Kritis [" + getId() + "] " + getNamaSungai()
            + ", Lokasi: " + getLokasi()
            + ", Kategori: " + getKomponenKategori().getTingkatanKeamanan()
            + ", Status: " + getKomponenStatus().getKondisiFisikAir()
            + ", persentase sunga yang terancam: " + persentaseAreaTerancam + "%";
         
    }
}
