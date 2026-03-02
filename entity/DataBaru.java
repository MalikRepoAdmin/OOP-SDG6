package entity;

public class DataBaru extends Admin {
    private String idDataBaru;
    private String tglData;
    private String hasilData;
    private String statusData;

    public DataBaru(String idAdmin, String idDataBaru, String tglData, String hasilData, String statusData) {
        super(idAdmin);
        this.idDataBaru = idDataBaru;
        this.tglData = tglData;
        this.hasilData = hasilData;
        this.statusData = statusData;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("--- Detail Data Baru ---");
        System.out.println("ID Data Baru : " + idDataBaru);
        System.out.println("Tanggal Data : " + tglData);
        System.out.println("Hasil Data   : " + hasilData);
        System.out.println("Status Data  : " + statusData);
    }

    public String getIdDataBaru() { return idDataBaru; }
    public void setIdDataBaru(String idDataBaru) { this.idDataBaru = idDataBaru; }
    public String getTglData() { return tglData; }
    public void setTglData(String tglData) { this.tglData = tglData; }
    public String getHasilData() { return hasilData; }
    public void setHasilData(String hasilData) { this.hasilData = hasilData; }
    public String getStatusData() { return statusData; }
    public void setStatusData(String statusData) { this.statusData = statusData; }
}
