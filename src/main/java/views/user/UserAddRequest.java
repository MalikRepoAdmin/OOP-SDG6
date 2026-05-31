package views.user;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public class UserAddRequest {
    
    @NotBlank(message = "ID User harus diisi")
	private String idUser;

    @NotBlank(message = "Nama User Harus Diisi")
    private String namaUser;

    @NotBlank(message = "Email Harus Diisi")
	private String email;

    @NotBlank(message = "Password Harus Diisi")
    private String password;

    @NotBlank(message = "Tanggal Lahir Harus Diisi")
    @Past(message = "Tanggal Lahir tidak valid, Tanggal lahir tidak boleh hari ini")
    private LocalDate tanggalLahir;

    private String tanggalLahirStr;

    private String pekerjaan;

    private String bio;

    private String domisili;


    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public String getNamaUser() {
        return namaUser;
    }
    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTanggalLahir() {
        return tanggalLahirStr;
    }
    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = LocalDate.parse(tanggalLahir);
        this.tanggalLahirStr = tanggalLahir;
    }
    public String getPekerjaan() {
        return pekerjaan;
    }
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getDomisili() {
        return domisili;
    }
    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }
}
