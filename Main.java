
import database.Database;
import database.impl.DatabaseMock;
import entity.AbstractComment;
import entity.Admin;
import entity.KategoriSungai;
import entity.StatusSungai;
import entity.Sungai;
import entity.User;
import entity.VerifikasiEmail;
import entity.impl.NewComment;
import entity.impl.OldComment;
import java.time.LocalDate;
import java.util.Scanner;   


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
        Sungai sungaiobj = new KategoriSungai();
        KategoriSungai kategoriSungaiObj = new KategoriSungai();
        StatusSungai statusSungaiObj = new StatusSungai();
        Scanner input = new Scanner(System.in);
        
        System.out.println("===== Input data Sungai =====");
        System.out.println("Input ID Sungai: " );
        sungaiobj.setId(input.nextInt());
        input.nextLine(); 

        System.out.println("Input Lokasi Sungai: " );
        sungaiobj.setLokasi(input.nextLine());

        System.out.println("Input Nama Sungai: " );
        sungaiobj.setNama(input.nextLine());

        System.out.println("Input Kategori Sungai: " );
        sungaiobj.setKategori(input.nextLine());

        System.out.println("Input Debit Air: " );
        kategoriSungaiObj.setDebit(input.nextLine());

        System.out.println("\n" );
        System.out.println("===== Input status Sungai =====");
        System.out.println("Input sumber sungai: " );
kategoriSungaiObj.setSumber(input.nextLine());
        System.out.println("input Ph Sungai: ");
        statusSungaiObj.setPh(input.nextDouble());

        System.out.println("\n" );
        System.out.println("===== Data Sungai =====");
        System.out.println("ID Sungai: " + sungaiobj.getId());
        System.out.println("Nama Sungai: " + sungaiobj.getNama());
        System.out.println("Lokasi Sungai: " + sungaiobj.getLokasi());
        System.out.println("Kategori Sungai: " + sungaiobj.getKategori());
        System.out.println("Debit Air: " + kategoriSungaiObj.getDebit());
        System.out.println ("Sumber air sungai: " + kategoriSungaiObj.getSumber());
        System.out.println("Ph Sungai: " + statusSungaiObj.getPh());
        statusSungaiObj.kualitasAir();
        
        /*
            OWNERSHIP: zahrah888
         */
        Admin adminobj = new Admin("244311060");

        adminobj.showData();

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

        VerifikasiEmail vE = new VerifikasiEmail(2, LocalDate.now().toString(), commentId, commentId);

        vE.tampilkanData();

    }

}
