package model;

public class User {
    private int idUser;
    private String nama;
    private String email;
    private String password;
    private String tanggalLahir;
    private String pekerjaan;
    private String bio;
    private String domisili;
    private String fotoProfil;

    public User(int idUser, String nama, String email, String password, String tanggalLahir, 
                String pekerjaan, String bio, String domisili, String fotoProfil) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.tanggalLahir = tanggalLahir;
        this.pekerjaan = pekerjaan;
        this.bio = bio;
        this.domisili = domisili;
        this.fotoProfil = fotoProfil;
    }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }

    public String getPekerjaan() { return pekerjaan; }
    public void setPekerjaan(String pekerjaan) { this.pekerjaan = pekerjaan; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getDomisili() { return domisili; }
    public void setDomisili(String domisili) { this.domisili = domisili; }

    public String getFotoProfil() { return fotoProfil; }
    public void setFotoProfil(String fotoProfil) { this.fotoProfil = fotoProfil; }
}
