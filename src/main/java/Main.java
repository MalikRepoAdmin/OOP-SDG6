

import database.Database;
import database.impl.DatabaseMock;
import entity.Admin;
import entity.DataBaru;
import entity.KategoriSungai;
import entity.StatusSungai;
import entity.Sungai;
import entity.User;
import entity.VerifikasiEmail;
import entity.impl.NewComment;
import entity.impl.OldComment;
import views.auth.LoginFrame;


import javax.swing.SwingUtilities;

/// Entry Point
public class Main {

    public static void main(String[] args) {
        System.out.println("Ini adalah program untuk test project OOP kami!\n\n");

        /*
            OWNERSHIP: MalikRepoAdmin
         */
        Database newDatabase = new DatabaseMock();

        NewComment newComment = new NewComment(newDatabase);
        newComment.addComment("Hello, World!", "254311011");
        newComment.sendComment();
        newComment.displaySendedComment();
        newComment.displayComment();
        newComment.displayCount();

        String commentId = String.valueOf(newComment.getCommentId());

        OldComment oldComment = new OldComment(newDatabase, commentId);
        oldComment.displayComment();
        oldComment.updateComment("Good Night, World...");
        oldComment.sendComment();
        oldComment.displaySendedComment();


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
        Admin adminobj = new Admin(1, "Zahrah Admin", "admin@example.com", "admin123", "ADM001");

        System.out.println("\nData Admin:");
        System.out.println("ID Admin: " + adminobj.getIdAdmin());
        System.out.println("Role Admin: " + adminobj.ambilNamaPeranSistem());
        System.out.println("Izin Verifikasi: " + adminobj.periksaIzinVerifikasi());

        DataBaru dbobj = new DataBaru(
            adminobj.getIdAdmin(),
            "DB-2026-001",
            "05-04-2026",
            "Kondisi air bersih",
            "Sedang Proses Verifikasi"
        );

        dbobj.showData();

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
