public class Admin {
    private String idAdmin;
    private String email = "zzzzzhrrr@gmail.com";
    private String password = "admin123";

    public Admin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void showData() {
        System.out.println("ID Admin : " + idAdmin);
        System.out.println("Email    : " + email);
    }
}
