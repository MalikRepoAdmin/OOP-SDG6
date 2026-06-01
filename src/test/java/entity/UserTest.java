package entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        User user = new User(
                10,
                "Budi",
                "budi@example.com",
                "secret123",
                "1995-06-15",
                "Programmer",
                "Penggemar sungai bersih",
                "Bandung",
                "budi.jpg"
        );

        assertAll("User constructor and getters",
                () -> assertEquals(10, user.getIdUser()),
                () -> assertEquals("Budi", user.getNama()),
                () -> assertEquals("budi@example.com", user.getEmail()),
                () -> assertEquals("secret123", user.getPassword()),
                () -> assertEquals("1995-06-15", user.getTanggalLahir()),
                () -> assertEquals("Programmer", user.getPekerjaan()),
                () -> assertEquals("Penggemar sungai bersih", user.getBio()),
                () -> assertEquals("Bandung", user.getDomisili()),
                () -> assertEquals("budi.jpg", user.getFotoProfil())
        );
    }

    @Test
    public void testSettersUpdateFields() {
        User user = new User(
                1,
                "Ayu",
                "ayu@example.com",
                "password",
                "2000-01-01",
                "Mahasiswa",
                "Mencintai lingkungan",
                "Jakarta",
                "ayu.png"
        );

        user.setIdUser(2);
        user.setNama("Ayunda");
        user.setEmail("ayunda@example.com");
        user.setPassword("newpass");
        user.setTanggalLahir("1999-12-31");
        user.setPekerjaan("Insinyur Lingkungan");
        user.setBio("Aktif di komunitas air bersih");
        user.setDomisili("Depok");
        user.setFotoProfil("ayunda.png");

        assertAll("User setters",
                () -> assertEquals(2, user.getIdUser()),
                () -> assertEquals("Ayunda", user.getNama()),
                () -> assertEquals("ayunda@example.com", user.getEmail()),
                () -> assertEquals("newpass", user.getPassword()),
                () -> assertEquals("1999-12-31", user.getTanggalLahir()),
                () -> assertEquals("Insinyur Lingkungan", user.getPekerjaan()),
                () -> assertEquals("Aktif di komunitas air bersih", user.getBio()),
                () -> assertEquals("Depok", user.getDomisili()),
                () -> assertEquals("ayunda.png", user.getFotoProfil())
        );
    }
}
