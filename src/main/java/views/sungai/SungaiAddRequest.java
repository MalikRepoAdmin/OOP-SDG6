package views.sungai;

import jakarta.validation.constraints.NotBlank;

public class SungaiAddRequest {

	@NotBlank(message = "Nama Sungai Harus Diisi")
	private String namaSungai;

	private String kategori;

	@NotBlank(message = "Status Sungai Harus Diisi")
	private String status;

	@NotBlank(message = "Alasan Prioritas harus diisi")
	private String alasanPrioritas;


	public String getNamaSungai() { return this.namaSungai; }
	public String getKategori() { return this.kategori; }
	public String getStatus() { return this.status; }
	public String getAlasanPrioritas() { return this.alasanPrioritas; }

	public void setNamaSungai(String namaSungai) { this.namaSungai = namaSungai; }
	public void setKategori(String kategori) { this.kategori = kategori; }
	public void setStatus(String status) { this.status = status; }
	public void setAlasanPrioritas(String alasanPrioritas) { this.alasanPrioritas = alasanPrioritas; }
}