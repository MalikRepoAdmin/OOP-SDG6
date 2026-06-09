import exception.InputTidakValidException;
import entity.UserVerifikasiEmail;
import services.UserService;

import java.util.Scanner;

public class UserController {

    UserService service = new UserService();
    Scanner sc = new Scanner(System.in);

    public void tambahUser() {

        try {
            System.out.print("Username: ");
            String username = sc.nextLine();

            if (username.isEmpty()) {
                throw new InputTidakValidException("Username tidak boleh kosong!");
            }

            System.out.print("Email: ");
            String email = sc.nextLine();

            if (!email.contains("@")) {
                throw new InputTidakValidException("Format email tidak valid!");
            }

            System.out.print("Status (TERVERIFIKASI / BELUM): ");
            String status = sc.nextLine();

            UserVerifikasiEmail user = new UserVerifikasiEmail(
                    DatabaseMockController.userIdCounter,
                    username,
                    email,
                    status
            );

            service.create(user);

            System.out.println("User berhasil ditambahkan!");

        } catch (InputTidakValidException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}