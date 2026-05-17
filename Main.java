import entity.User;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== FIX BUG VERSION ===");

        try {
            String inputId = "abc"; // data salah sengaja
            int idUser = Integer.parseInt(inputId);

            System.out.println("ID User: " + idUser);

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: ID harus berupa angka!");
        }

        User user = new User(
            1,
            null, // sengaja null
            "test@gmail.com",
            "123",
            "2000-01-01",
            "Mahasiswa",
            "Bio",
            "Surabaya",
            "foto.jpg"
        );

        try {
            System.out.println(user.getNama().toUpperCase());

        } catch (NullPointerException e) {
            System.out.println("❌ Error: Nama user tidak boleh null!");
        } finally {
            System.out.println("ℹ️ Proses pengecekan user selesai (finally block)");
        }

        System.out.println("=== PROGRAM SELESAI ===");
    }
}

