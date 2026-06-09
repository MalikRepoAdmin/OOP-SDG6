
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Admin;
import entity.DataBaru;
import entity.InvalidInputException;
import entity.KategoriSungai;
import entity.StatusSungai;
import entity.Sungai;
import entity.SungaiKritis;
import entity.User;
import entity.VerifikasiEmail;

/// Entry Point
public class Main {

    public static void main(String[] args) {
        System.out.println("Ini adalah program untuk test project OOP kami!\n\n");

        /*
            OWNERSHIP: MalikRepoAdmin
         */
        // Database newDatabase = new DatabaseMock();

        // NewComment newComment = new NewComment(newDatabase);
        // newComment.addComment("Hello, World!", "254311011");
        // newComment.sendComment();
        // newComment.displaySendedComment();
        // newComment.displayComment();
        // newComment.displayCount();

        // String commentId = String.valueOf(newComment.getCommentID());

        // OldComment oldComment = new OldComment(newDatabase, commentId);
        // oldComment.displayComment();
        // oldComment.updateComment("Good Night, World...");
        // oldComment.sendComment();
        // oldComment.displaySendedComment();

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

        // Daftar Sungai
        List<Sungai> daftarSungai = new ArrayList<>();
        daftarSungai.add(sungaiobj);
        daftarSungai.add(new SungaiKritis(
                2,
                "Ciliwung",
                "Jakarta",
                new KategoriSungai("Kritis", "Sungai dengan risiko tinggi"),
                new StatusSungai(0.95, "SANGAT TERPENCEMAR"),
                78.5
        ));

        // Menu Sungai
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\n=== Menu Sungai ===");
                System.out.println("1. Tampilkan semua sungai");
                System.out.println("2. Tampilkan hanya sungai kritis (Filter)");
                System.out.println("3. Tambah sungai kritis baru");
                System.out.println("4. Keluar");
                System.out.print("Pilih opsi (1-4): ");

                String pilihan = scanner.nextLine().trim();

                switch (pilihan) {
                    case "1":
                        tampilkanSemuaSungai(daftarSungai);
                        break;
                    case "2":
                        tampilkanSungaiKritis(daftarSungai);
                        break;
                    case "3":
                        try {
                            SungaiKritis baru = buatSungaiKritis(scanner);
                            daftarSungai.add(baru);
                            System.out.println("Sungai Kritis berhasil ditambahkan!");
                        } catch (InvalidInputException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case "4":
                        running = false;
                        System.out.println("Program selesai. Terima kasih!");
                        break;
                    default:
                        System.out.println("Opsi tidak valid. Silakan pilih 1-4.");
                }
            }
        }

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

    // Method untuk menampilkan semua sungai
    private static void tampilkanSemuaSungai(List<Sungai> daftarSungai) {
        System.out.println("\n--- Daftar Semua Sungai ---");
        if (daftarSungai.isEmpty()) {
            System.out.println("Tidak ada data sungai.");
            return;
        }
        for (int i = 0; i < daftarSungai.size(); i++) {
            System.out.println((i + 1) + ". " + daftarSungai.get(i).tampilkanDetail());
        }
    }

    // Method untuk filter: menampilkan hanya Sungai Kritis
    private static void tampilkanSungaiKritis(List<Sungai> daftarSungai) {
        System.out.println("\n--- Daftar Sungai Kritis (Filter) ---");
        List<SungaiKritis> sungaiKritisList = new ArrayList<>();
        for (Sungai s : daftarSungai) {
            if (s instanceof SungaiKritis) {
                sungaiKritisList.add((SungaiKritis) s);
            }
        }

        if (sungaiKritisList.isEmpty()) {
            System.out.println("Tidak ada sungai kritis.");
            return;
        }

        for (int i = 0; i < sungaiKritisList.size(); i++) {
            SungaiKritis sk = sungaiKritisList.get(i);
            System.out.println((i + 1) + ". " + sk.tampilkanDetail());
        }
    }

    // method input data sungai
    private static SungaiKritis buatSungaiKritis(Scanner scanner) throws InvalidInputException {
        System.out.print("Masukkan ID Sungai: ");
        String idStr = scanner.nextLine().trim();
        if (idStr.isEmpty()) {
            throw new InvalidInputException("ID tidak boleh kosong.");
        }
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("ID harus berupa angka.");
        }

        System.out.print("Masukkan Nama Sungai: ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) {
            throw new InvalidInputException("Nama sungai tidak boleh kosong.");
        }

        System.out.print("Masukkan Lokasi Sungai: ");
        String lokasi = scanner.nextLine().trim();
        if (lokasi.isEmpty()) {
            throw new InvalidInputException("Lokasi sungai tidak boleh kosong.");
        }

        System.out.print("Masukkan Indeks Pencemaran (0.0-1.0): ");
        String indeksStr = scanner.nextLine().trim();
        if (indeksStr.isEmpty()) {
            throw new InvalidInputException("Indeks pencemaran tidak boleh kosong.");
        }
        double indeks;
        try {
            indeks = Double.parseDouble(indeksStr);
            if (indeks < 0 || indeks > 1) {
                throw new InvalidInputException("Indeks pencemaran harus antara 0.0 dan 1.0.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Indeks pencemaran harus berupa angka desimal.");
        }

        System.out.print("Masukkan Kondisi Fisik Air: ");
        String kondisi = scanner.nextLine().trim();
        if (kondisi.isEmpty()) {
            throw new InvalidInputException("Kondisi fisik air tidak boleh kosong.");
        }

        System.out.print("Masukkan Persentase Area Terancam (0-100): ");
        String persentaseStr = scanner.nextLine().trim();
        if (persentaseStr.isEmpty()) {
            throw new InvalidInputException("Persentase area terancam tidak boleh kosong.");
        }
        double persentase;
        try {
            persentase = Double.parseDouble(persentaseStr);
            if (persentase < 0 || persentase > 100) {
                throw new InvalidInputException("Persentase harus antara 0 dan 100.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Persentase harus berupa angka.");
        }

        return new SungaiKritis(
                id,
                nama,
                lokasi,
                new KategoriSungai("Kritis", "Sungai dengan risiko tinggi"),
                new StatusSungai(indeks, kondisi),
                persentase
        );
    }

}
