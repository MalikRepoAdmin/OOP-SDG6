

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
import java.time.LocalDate;

/// Entry Point
public class Main {

    public static void main(String[] args) {
        System.out.println("Ini adalah program untuk test project OOP kami!\n\n");


        /*
            OWNERSHIP: MalikRepoAdmin
         */
        // Instantiate DatabaseMock
        // This Database instantiation is based on Interface type to decouple and demonstrate polymorphism
        Database newDatabase = new DatabaseMock();


        // NewComment and OldComment constructor depends on interface type Database
        // we can freely change the database instance into DatabaseMysql easily as a proof of polymorphism
        // Instantiate NewComment
        NewComment newComment = new NewComment(newDatabase);
        newComment.addComment("Hello, World!", "254311011");
        newComment.sendComment();
        newComment.displaySendedComment();
        newComment.displayComment();
        newComment.displayCount();

        String commentId = String.valueOf(newComment.getCommentID());

        // Instantiate OldComment
        OldComment oldComment = new OldComment(newDatabase, commentId);
        oldComment.displayComment();
        oldComment.updateComment("Good Night, World...");
        oldComment.sendComment();
        oldComment.displaySendedComment();


        /*
            OWNERSHIP: raditCDlk
         */
        Sungai sungaiobj = new Sungai();

        sungaiobj.setId(1);
        sungaiobj.setNama("citarum");
        sungaiobj.setLokasi("jawa Barat");
        sungaiobj.setKategori("layak pakai");
        sungaiobj.setStatus("BERSIH");

        System.out.println("ID Sungai: " + sungaiobj.getId());
        System.out.println("Nama Sungai: " + sungaiobj.getNama());
        System.out.println("Lokasi Sungai: " + sungaiobj.getLokasi());
        System.out.println("Kategori Sungai: " + sungaiobj.getKategori());
        System.out.println("Status Sungai: " + sungaiobj.getStatus());

        /*
            OWNERSHIP: zahrah888
         */
        Admin adminobj = new Admin("ADM001");

        adminobj.showDataAdmin();

        DataBaru dbobj = new DataBaru (
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
        User u = new User(1, "Angelis Nasta Nadia", "angelynas@gmail.com", 
        "12345", "12-08-2005", "Mahasiswa", 
        "Peduli lingkungan", "Jakarta", "foto.jpg");


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

        VerifikasiEmail vE = new VerifikasiEmail(1, "Angelis Nasta Nadia", "angelynas@gmail.com", 
        "12345", "12-08-2005", "Mahasiswa", 
        "Peduli lingkungan", "Jakarta", "foto.jpg", 1, "05-04-2026", "05-04-2026", "verified");

        vE.tampilkanData();

    }

}
