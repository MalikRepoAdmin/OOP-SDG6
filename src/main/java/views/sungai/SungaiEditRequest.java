package views.sungai;

import jakarta.validation.constraints.AssertTrue;

public class SungaiEditRequest {

	private String namaSungai;
	private String kategori;
	private String status;


	public String getNamaSungai() { return this.namaSungai; }
	public String getKategori() { return this.kategori; }
	public String getStatus() { return this.status; }

	public void setNamaSungai(String namaSungai) { this.namaSungai = namaSungai; }
	public void setKategori(String kategori) { this.kategori = kategori; }
	public void setStatus(String status) { this.status = status; }

	@AssertTrue(message = "Salah Satu Attribut harus diedit")
	public boolean isAtLeastOneFieldNotBlank() {
		return 	(this.namaSungai != null && !this.namaSungai.isBlank()) ||
				(this.kategori != null && !this.kategori.isBlank()) ||
				(this.status != null && !this.status.isBlank());
	}
}