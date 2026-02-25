import database.Database;
import database.impl.DatabaseMock;
import entity.AbstractComment;
import entity.impl.NewComment;
import entity.impl.OldComment;
import entity.Sungai;
import entity.Admin;
import entity.User;

/// Entry Point
public class Main {
    public static void main(String[] args) {
        System.out.println("Ini adalah program untuk test project OOP kami!\n\n");


        /*
            OWNERSHIP: MalikRepoAdmin
        */

        // Instantiate DatabaseMock
        Database newDatabase = new DatabaseMock();

        // Instantiate NewComment
        AbstractComment newComment = new NewComment(newDatabase);
        newComment.addComment("Hello, World!", "254311011");
        newComment.sendComment();
        newComment.displaySendedComment();
        newComment.displayComment();
        newComment.displayCount();

        String commentId = String.valueOf(newComment.getCommentID());

        // Instantiate OldComment
        AbstractComment oldComment = new OldComment(newDatabase, commentId);
        oldComment.displayComment();
        oldComment.updateComment("Good Night, World...");
        oldComment.sendComment();
        oldComment.displaySendedComment();


        /*
            OWNERSHIP: raditCDlk
        */

        Sungai sungaiobj = new Sungai();

        sungaiobj.setnama("citarum");
        sungaiobj.setLokasi("jawa Barat");
        sungaiobj.getId(1);
        sungaiobj.setStatus("BERSIH");
        sungaiobj.showdata();

        /*
            OWNERSHIP: zahrah888
        */

        Admin adminobj = new Admin();
        
        adminobj.set_id("A001");
        adminobj.set_email("admin123@gmail.com");
        adminobj.set_pass("admin123");

        adminobj.showdata();

        /*
            OWNERSHIP: AngelisNadia
        */

        User u = new User();

        u.mengisiData(
                1,
                "Angelis Nasta Nadia",
                "angelynas@gmail.com",
                "12345",
                "12-08-2005",
                "Mahasiswa",
                "Peduli lingkungan",
                "Jakarta",
                "foto.jpg");

        System.out.print("\n\n");
        System.out.println("ID User: " + u.mengambilIdUser());
        System.out.println("Nama: " + u.mengambilNama());
        System.out.println("Email: " + u.mengambilEmail());
        System.out.println("Password: " + u.mengambilPassword());
        System.out.println("Tanggal Lahir: " + u.mengambilTanggalLahir());
        System.out.println("Pekerjaan: " + u.mengambilPekerjaan());
        System.out.println("Bio: " + u.mengambilBio());
        System.out.println("Domisili: " + u.mengambilDomisili());
        System.out.println("Foto Profil: " + u.mengambilFotoProfil());

    }

}
