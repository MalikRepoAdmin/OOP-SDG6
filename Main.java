
import database.Database;
import database.impl.DatabaseMock;
import entity.AbstractComment;
import entity.Admin;
import entity.KategoriSungai;
import entity.User;
import entity.VerifikasiEmail;
import entity.impl.NewComment;
import entity.impl.OldComment;
import java.time.LocalDate;
import java.util.InputMismatchException;
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
        KategoriSungai sungai = new KategoriSungai();
        Scanner input = new Scanner(System.in);

        System.out.println("===== Input data Sungai =====");
        while (true) {

            try {

                System.out.print("Input ID Sungai: ");
                sungai.setId(input.nextInt());
                input.nextLine();

                break;

            } catch (InputMismatchException e) {

                System.out.println("Error: ID Sungai harus berupa angka!");
                input.nextLine();
            }
        }

        System.out.println("Input Lokasi Sungai: ");
        sungai.setLokasi(input.nextLine());
        System.out.println("Input Nama Sungai: ");
        sungai.setNama(input.nextLine());

        System.out.println("Input Debit Air (m3/s): ");
        sungai.setDebit(input.nextLine());

        System.out.println("\n");
        System.out.println("===== Input status Sungai =====");
        System.out.println("Input sumber sungai (hujan,pegunungan,laut,danau): ");
        sungai.setSumber(input.nextLine());
        System.out.println("input Ph Sungai: ");
        sungai.setPh(input.nextDouble());

        System.out.println("\n");
        System.out.println("===== Data Sungai =====");
        System.out.println("ID Sungai: " + sungai.getId());
        System.out.println("Nama Sungai: " + sungai.getNama());
        System.out.println("Lokasi Sungai: " + sungai.getLokasi());
        System.out.println("Debit Air Sungai : " + sungai.getDebit() + " m3/s");

        System.out.println("Sumber Air Sungai : " + sungai.getSumber());
        sungai.sumberAir();
        System.out.println("Kategori Sungai : " + sungai.getKategori());
        System.out.println("Ph Sungai: " + sungai.getPh());
        sungai.kualitasAir();

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
