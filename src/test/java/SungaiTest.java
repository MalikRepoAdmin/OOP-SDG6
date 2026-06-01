

import org.junit.jupiter.api.Test;

import entity.KategoriSungai;
import entity.StatusSungai;
import entity.Sungai;

import static org.junit.jupiter.api.Assertions.*;

public class SungaiTest {

    @Test
    public void testConstructorAndGetters() {
        KategoriSungai kategori = new KategoriSungai("Aman", "Sungai layak pantau");
        StatusSungai status = new StatusSungai(2.5, "Jernih");
        Sungai sungai = new Sungai(1, "Ciliwung", "Jakarta", kategori, status);

        assertEquals(1, sungai.getId());
        assertEquals("Ciliwung", sungai.getNamaSungai());
        assertEquals("Jakarta", sungai.getLokasi());
        assertSame(kategori, sungai.getKomponenKategori());
        assertSame(status, sungai.getKomponenStatus());
        assertEquals("Aman", sungai.getKomponenKategori().getTingkatanKeamanan());
        assertEquals("Jernih", sungai.getKomponenStatus().getKondisiFisikAir());
    }

    @Test
    public void testSettersUpdateProperties() {
        KategoriSungai kategori = new KategoriSungai("Sedang", "Perlu pengawasan");
        StatusSungai status = new StatusSungai(4.0, "Keruh");
        Sungai sungai = new Sungai(2, "Brantas", "Malang", kategori, status);

        sungai.setId(3);
        sungai.setNamaSungai("Progo");
        sungai.setLokasi("Yogyakarta");

        KategoriSungai newKategori = new KategoriSungai("Berisiko", "Harus ditindaklanjuti");
        StatusSungai newStatus = new StatusSungai(7.1, "Sangat tercemar");
        sungai.setKomponenKategori(newKategori);
        sungai.setKomponenStatus(newStatus);

        assertEquals(3, sungai.getId());
        assertEquals("Progo", sungai.getNamaSungai());
        assertEquals("Yogyakarta", sungai.getLokasi());
        assertSame(newKategori, sungai.getKomponenKategori());
        assertSame(newStatus, sungai.getKomponenStatus());
        assertEquals("Berisiko", sungai.getKomponenKategori().getTingkatanKeamanan());
        assertEquals(7.1, sungai.getKomponenStatus().getIndeksPencemaran());
    }
}
