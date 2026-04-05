package entity;

public class Admin extends User {
    private String idAdmin;

    public Admin(String idAdmin) {
        this.idAdmin = ADM001;
        this.email = "zzzzzhrrr@gmail.com";
        this.password = "admriverX12";
        this.nama = "Zahrah";
    }

    public void showDataAdmin() {
        System.out.println("ID Admin : " + idAdmin);
        System.out.println("Email    : " + email);
        System.out.println("Nama     : " + nama);
    }
}
