package entity;

public class Admin extends User {
    private String idAdmin;

    public Admin(String idAdmin) {
                            
        super(2, "", "", "", "",
              "", "", "", "");
        this.idAdmin = "ADM001";
        this.setEmail("zzzzzhrrr@gmail.com");
        this.setPassword("admriverX12");
        this.setNama("Zahrah");
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void showDataAdmin() {
        System.out.println("ID Admin : " + idAdmin);
        System.out.println("Email    : " + getEmail());
        System.out.println("Nama     : " + getNama());
    }
}
