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
        System.out.println("ID admin : " +id_admin);
        System.out.println("Email : " +email);
        System.out.println("Password : " +password);
    }

    public static void main (String[] args){
        Admin adminobj = new Admin();
        
        adminobj.set_id("A001");
        adminobj.set_email("admin123@gmail.com");
        adminobj.set_pass("admin123");

        adminobj.showdata();
    }
}
