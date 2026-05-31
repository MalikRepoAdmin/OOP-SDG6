package views.user;

import java.time.LocalDate;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Past;

public class UserEditRequest {

    private String namaUser;

    @Past(message = "Tanggal Lahir tidak valid, Tanggal lahir harus Masa Lampau")
    private LocalDate tanggalLahir;

    private String tanggalLahirStr;

    private String pekerjaan;

    private String bio;

    private String domisili;


    @AssertTrue(message = "Salah Satu Kolom harus diisi")
	public boolean isAtLeastOneFieldNotBlank() {
		return 	(this.namaUser != null && !this.namaUser.isBlank()) ||
                (this.tanggalLahirStr != null && !this.tanggalLahirStr.isBlank()) ||
                (this.pekerjaan != null && !this.pekerjaan.isBlank()) ||
                (this.bio != null && !this.bio.isBlank()) ||
                (this.domisili != null && !this.domisili.isBlank());
                
	}


    public String getNamaUser() {
        return namaUser;
    }
    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
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
