package entity;

public class Admin extends User implements Actionable {
    private String idAdmin;

    public Admin(String idAdmin, String nama, String email, String password) {
        super(2, nama, email, password, "", "", "", "", ""); 
        this.idAdmin = idAdmin;
        
        this.setNama(nama);
        this.setEmail(email);
        this.setPassword(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== DATA ADMIN (LOGGED IN) ===");
        System.out.println("ID Admin : " + idAdmin);
        System.out.println("Nama     : " + getNama());
        System.out.println("Email    : " + getEmail());
    }
}
