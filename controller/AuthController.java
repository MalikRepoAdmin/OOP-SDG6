public class AuthController {

    private AuthService service = new AuthService();

    public void register(User u) {
        service.register(u);
    }

    public User login(String email, String password) {
        return service.login(email, password);
    }
}