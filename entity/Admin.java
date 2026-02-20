package entity;

public class Admin {
    String id_admin, email;
    String password;

    public void set_email(String email){
        this.email = email;
    }

    public void set_id(String id){
        this.id_admin = id;
    }

    public void set_pass(String password){
        this.password = password;
    }

    public void showdata(){
        System.out.print("\n\n");
        System.out.println("ID admin : " +id_admin);
        System.out.println("Email : " +email);
        System.out.println("Password : " +password);
    }
}
