package views.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank(message = "Email tidak boleh Kosong!")
	@Email(message = "Format Email tidak valid")
	private String email;

	@NotBlank(message = "Password tidak boleh Kosong!")
	private String password;


	public LoginRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
}