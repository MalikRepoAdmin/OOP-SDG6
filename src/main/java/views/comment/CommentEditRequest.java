package views.comment;

import jakarta.validation.constraints.NotBlank;

public class CommentEditRequest {

	@NotBlank(message = "Komentar harus diisi")
	private String isiKomentar;

	private String tanggalModified;


	public String getIsiKomentar() { return this.isiKomentar; }
	public String getTanggalModified() { return this.tanggalModified; }

	public void setIsiKomentar(String isiKomentar) { this.isiKomentar = isiKomentar; }
	public void setTanggalModified(String tanggalModified) { this.tanggalModified = tanggalModified; }
}