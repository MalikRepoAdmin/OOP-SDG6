package services;

import database.impl.DatabaseMockController;
import entity.Admin;

public class AuthService {

    public boolean register(Admin admin) {
        DatabaseMockController.admins.add(admin);
        DatabaseMockController.adminIdCounter += 1;
        DatabaseMockController.userIdCounter += 1;
        return true;
    }

    public boolean login(String email, String password) {
        for (Admin a : DatabaseMockController.admins) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}