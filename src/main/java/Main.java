

import javax.swing.SwingUtilities;

import entity.Admin;
import entity.KategoriSungai;
import entity.StatusSungai;
import entity.Sungai;
import entity.SungaiMonitoring;
import entity.User;
import entity.VerifikasiEmail;
import views.auth.LoginFrame;

/// Entry Point
public class Main {

    public static void main(String[] args) {
        System.out.println("Ini adalah program untuk test project OOP kami!\n\n");

        /*
            OWNERSHIP: MalikRepoAdmin
         */
        
        // Test Swing UI
        SwingUtilities.invokeLater(() -> {

            LoginFrame frame =
                    new LoginFrame();

            frame.setVisible(true);
        });

        
        /*
            OWNERSHIP: raditCDlk
         */
        Sungai sungaiobj = new Sungai(
            1,
            "Citarum",
            "Jawa Barat",
            new KategoriSungai("Layak Pakai", "Air aman untuk irigasi dan industri ringan"),
            new StatusSungai(0.75, "BERSIH")
        );

        System.out.println("ID Sungai: " + sungaiobj.getId());
        System.out.println("Nama Sungai: " + sungaiobj.getNamaSungai());
        System.out.println("Lokasi Sungai: " + sungaiobj.getLokasi());
        System.out.println("Kategori Sungai: " + sungaiobj.getKomponenKategori().getTingkatanKeamanan());
        System.out.println("Status Sungai: " + sungaiobj.getKomponenStatus().getKondisiFisikAir());

        /*
            OWNERSHIP: zahrah888
         */
        Admin adminobj = new Admin(1, 1, "Zahrah Admin", "admin@example.com", "admin123", "09-21-2005", "Mahasiswa", "", "Magetan");

        System.out.println("\nData Admin:");
        System.out.println("ID Admin: " + adminobj.getIdAdmin());
        System.out.println("Role Admin: " + adminobj.ambilNamaPeranSistem());
        System.out.println("Izin Verifikasi: " + adminobj.periksaIzinVerifikasi());

        /* PENERAPAN POLIMORFISME
        */
      // Objek subclass disimpan ke variabel tipe superclass (Sungai)
       Sungai sungaiPantau = new SungaiMonitoring(
       2, 
       "Sungai Bengawan", 
       "Solo", 
       new KategoriSungai("Sedang", "Perlu Pengawasan"), 
       new StatusSungai(0.5, "CUKUP"), 
       6.8 // nilai phAir (atribut unik)
);

       sungaiPantau.tampilkanDetail();

        /*
            OWNERSHIP: AngelisNadia
         */
        User u = new User(
            1,
            "Angelis Nasta Nadia",
            "angelynas@gmail.com",
            "12345",
            "12-08-2005",
            "Mahasiswa",
            "Peduli lingkungan",
            "Jakarta",
            "foto.jpg"
        );

        System.out.print("\n\n");
        System.out.println("ID User: " + u.getIdUser());
        System.out.println("Nama: " + u.getNama());
        System.out.println("Email: " + u.getEmail());
        System.out.println("Password: " + u.getPassword());
        System.out.println("Tanggal Lahir: " + u.getTanggalLahir());
        System.out.println("Pekerjaan: " + u.getPekerjaan());
        System.out.println("Bio: " + u.getBio());
        System.out.println("Domisili: " + u.getDomisili());
        System.out.println("Foto Profil: " + u.getFotoProfil());

        VerifikasiEmail vE = new VerifikasiEmail(
            1,
            "05-04-2026",
            "05-04-2026",
            "verified",
            u
        );

        System.out.println("\nData Verifikasi Email:");
        System.out.println("ID Verifikasi: " + vE.getIdVerifikasi());
        System.out.println("Tanggal Kirim: " + vE.getTanggalKirim());
        System.out.println("Tanggal Verifikasi: " + vE.getTanggalVerifikasi());
        System.out.println("Status Email: " + vE.getStatusEmail());
        System.out.println("Target User: " + vE.getTargetUser().getNama());
    }

}
