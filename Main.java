import entity.User;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== VALIDATION SYSTEM START ===");

        String inputId = "abc";   // simulasi input salah
        String nama = "";         // kosong sengaja

        int idUser = -1;

        try {
            if (inputId == null || inputId.trim().isEmpty()) {
                throw new IllegalArgumentException("ID tidak boleh kosong");
            }

            idUser = Integer.parseInt(inputId);

            if (idUser <= 0) {
                throw new IllegalArgumentException("ID harus lebih dari 0");
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: ID harus berupa angka!");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validasi Error: " + e.getMessage());
            return;
        }

        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("❌ Validasi Error: Nama tidak boleh kosong!");
            return;
        }

        User user = new User(
            idUser,
            nama,
            "test@gmail.com",
            "123",
            "2000-01-01",
            "Mahasiswa",
            "Bio",
            "Surabaya",
            "foto.jpg"
        );

        System.out.println("✔ User berhasil dibuat!");
        user.showData();

        System.out.println("=== PROGRAM SELESAI ===");
    }
}
