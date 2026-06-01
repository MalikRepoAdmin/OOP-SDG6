package controller;

import entity.Admin;
import services.AuthService;

public class AuthController {

    private AuthService service = new AuthService();

    public void register(Admin u) {
        service.register(u);
    }

    public boolean login(String email, String password) {
        return service.login(email, password);
    }
}