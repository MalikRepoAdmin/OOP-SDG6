package entity;
public class User {

    public int idUser;
    public String nama;
    public String email;
    public String password;
    public String tanggalLahir;
    public String pekerjaan;
    public String bio;
    public String domisili;
    public String fotoProfil;

    public void mengisiData(int iduser, String namalengkap, String mail, String pass,
            String tgllahir, String kerja, String biodata,
            String alamat, String foto) {

        idUser = iduser;
        nama = namalengkap;
        email = mail;
        password = pass;
        tanggalLahir = tgllahir;
        pekerjaan = kerja;
        bio = biodata;
        domisili = alamat;
        fotoProfil = foto;
    }

    public int mengambilIdUser() {
        return idUser;
    }

    public String mengambilNama() {
        return nama;
    }

    public String mengambilEmail() {
        return email;
    }

    public String mengambilPassword() {
        return password;
    }

    public String mengambilTanggalLahir() {
        return tanggalLahir;
    }

    public String mengambilPekerjaan() {
        return pekerjaan;
    }

    public String mengambilBio() {
        return bio;
    }

    public String mengambilDomisili() {
        return domisili;
    }

    public String mengambilFotoProfil() {
        return fotoProfil;
    }
}
