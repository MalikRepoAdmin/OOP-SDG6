package entity;

// Memenuhi SRP & Has-A Relation: Sungai bertindak sebagai superclass data fisik utama objek pantau
public class Sungai {
    // Properti dasar identitas fisik sungai
    private int id;
    private String namaSungai;
    private String lokasi;
    
    // Hubungan Komposisi: Mengaitkan komponen objek murni Kategori dan Status ke dalam Sungai
    private KategoriSungai komponenKategori;
    private StatusSungai komponenStatus;

    // Constructor utama penampung parameter teks dan parameter objek relasi murni
    public Sungai(int id, String namaSungai, String lokasi, KategoriSungai komponenKategori, StatusSungai komponenStatus) {
        this.id = id;
        this.namaSungai = namaSungai;
        this.lokasi = lokasi;
        this.komponenKategori = komponenKategori;
        this.komponenStatus = komponenStatus;
    }


    // Getter dan Setter penegakan Enkapsulasi
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNamaSungai() { return namaSungai; }
    public void setNamaSungai(String namaSungai) { this.namaSungai = namaSungai; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public KategoriSungai getKomponenKategori() { return komponenKategori; }
    public void setKomponenKategori(KategoriSungai komponenKategori) { this.komponenKategori = komponenKategori; }

    public StatusSungai getKomponenStatus() { return komponenStatus; }
    public void setKomponenStatus(StatusSungai komponenStatus) { this.komponenStatus = komponenStatus; }

    // Method untuk Polimorfisme
    public void tampilkanDetail() {
        System.out.println("ID: " + this.id);
        System.out.println("Nama Sungai: " + this.namaSungai);
        System.out.println("Lokasi: " + this.lokasi);
        System.out.println("Kategori: " + this.komponenKategori.getTingkatanKeamanan());
        System.out.println("Status: " + this.komponenStatus.getKondisiFisikAir());

    // Pastikan kelas KategoriSungai dan StatusSungai memiliki method untuk menampilkan data
        System.out.println("Kategori: " + this.komponenKategori.getTingkatanKeamanan()); 
        System.out.println("Status: " + this.komponenStatus.getKondisiFisikAir());
    }
}


 