package model;

public class Sungai {
    private int id;
    private String namaSungai;
    private String lokasi;
    private String kategori;
    private String status;

    public Sungai(int id, String namaSungai, String lokasi, String kategori, String status) {
        this.id = id;
        this.namaSungai = namaSungai;
        this.lokasi = lokasi;
        this.kategori = kategori;
        this.status = status;
    }

    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNamaSungai() { 
        return namaSungai; 
    }
    
    public void setNamaSungai(String namaSungai) { 
        this.namaSungai = namaSungai; 
    }

    public String getLokasi() { 
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
