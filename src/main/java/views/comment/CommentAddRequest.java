package views.comment;

import jakarta.validation.constraints.NotBlank;

public class CommentAddRequest {

	@NotBlank(message = "ID User Harus Diisi")
	private String idUser;

	@NotBlank(message = "Nama User Harus Diisi")
	private String namaUser;

	@NotBlank(message = "Komentar harus diisi")
	private String isiKomentar;

	private String tanggalCreated;


	public String getIdUser() { return this.idUser; }
	public String getNamaUser() { return this.namaUser; }
	public String getIsiKomentar() { return this.isiKomentar; }
	public String getTanggalCreated() { return this.tanggalCreated; }

	public void setIdUser(String idUser) { this.idUser = idUser; }
	public void setIsiKomentar(String isiKomentar) { this.isiKomentar = isiKomentar; }
	public void setTanggalCreated(String tanggalCreated) { this.tanggalCreated = tanggalCreated; }
	public void setNamaUser(String namaUser) { this.namaUser = namaUser; }
}