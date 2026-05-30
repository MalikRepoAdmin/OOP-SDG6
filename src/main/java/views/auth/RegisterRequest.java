package views.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

	@NotBlank(message = "Email tidak boleh Kosong!")
	@Email(message = "Format Email tidak valid")
	private String email;

	@NotBlank(message = "Password tidak boleh Kosong!")
	@Size(min = 6, max = 20, message = "Panjang Password Minimal 6 karakter dan Maksimal 20 Karakter")
	private String password;


	public RegisterRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
}