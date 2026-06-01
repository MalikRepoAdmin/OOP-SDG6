package entity;

// Keyword 'extends' membuktikan hubungan 'Is-A' bahwa Admin mewarisi akun dasar dari User
// Keyword 'implements' mengunci Admin agar wajib mematuhi seluruh kontrak metode dari Verifikator
public class Admin extends User implements Verifikator {
    
    // Atribut unik yang hanya dimiliki oleh akun Admin, dibatasi ketat menggunakan modifier private
    private int idAdmin;
    private String logWaktuAktivitas;

    // Constructor murni untuk instansiasi objek Admin secara dinamis dari luar kelas
    public Admin(int idAdmin, int idUser, String nama, String email, String password, String tanggalLahir, String pekerjaan, String bio, String domisili) {
        
        // super() wajib dipanggil di baris pertama untuk mengirim data kredensial login ke parent (User)
        // Atribut profil warga lainnya sengaja diisi default "-" karena Admin adalah orang yang berbeda
        super(idUser, nama, email, password, tanggalLahir, pekerjaan, bio, domisili, "-");
        
        // Inisialisasi variabel internal spesifik milik objek Admin
        this.idAdmin = idAdmin;
        this.logWaktuAktivitas = "Belum ada aktivitas"; // Mengatur status log awal sistem
    }

    // Metode Getter untuk mengambil nilai idAdmin yang terenkapsulasi private
    public int getIdAdmin() { 
        return idAdmin; 
    }

    // Metode Setter untuk memperbarui nilai idAdmin dari luar kelas secara aman
    public void setIdAdmin(int idAdmin) { 
        this.idAdmin = idAdmin; 
    }

    // Polimorfisme: Mengimplementasikan metode wajib dari interface Verifikator
    @Override
    public String ambilNamaPeranSistem() { 
        return "ADMIN_VERIFIKATOR_UTAMA"; // Mengembalikan identitas role murni berbentuk String
    }

    // Polimorfisme: Mengunci otoritas perizinan murni sistem untuk memvalidasi laporan
    @Override
    public boolean periksaIzinVerifikasi() { 
        return true; // Mengembalikan nilai true karena Admin memegang hak akses mutlak
    }

    // Polimorfisme: Menyediakan slot untuk memperbarui jejak waktu aktivitas verifikasi terakhir
    @Override
    public void catatWaktuAktivitasTerakhir(String tanggalDanWaktu) { 
        this.logWaktuAktivitas = tanggalDanWaktu; // Menyimpan input tanggal secara dinamis ke variabel
    }

    // Polimorfisme: Menyediakan metode untuk menarik data log waktu audit trail
    @Override
    public String ambilWaktuAktivitasTerakhir() { 
        return this.logWaktuAktivitas; 
    }
}
