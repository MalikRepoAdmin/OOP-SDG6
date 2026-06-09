package entity;

public class SungaiPrioritas extends Sungai{

	protected String alasanPrioritas;

	public SungaiPrioritas(int id, String namaSungai, String lokasi, KategoriSungai komponenKategori, StatusSungai komponenStatus, String alasanPrioritas) {
		
		super(id, namaSungai, lokasi, komponenKategori, komponenStatus);

		this.alasanPrioritas = alasanPrioritas;
	}

	@Override
	public String getFormattedNamaSungai() {

		return String.format("Nama Sungai(Prioritas): %s", namaSungai);
	}
}