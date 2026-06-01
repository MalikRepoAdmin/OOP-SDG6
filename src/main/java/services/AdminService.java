package services;

import java.util.List;

import database.impl.DatabaseMockController;
import entity.Admin;

public class AdminService {

    public void create(Admin f) {
        DatabaseMockController.admins.add(f);
        DatabaseMockController.userIdCounter++;
        DatabaseMockController.adminIdCounter++;
    }

    public List<Admin> getAll() {
        return DatabaseMockController.admins;
    }

    public boolean update(int id, Admin dataBaru) {
        for (int i = 0; i < DatabaseMockController.admins.size(); i++) {
            if (DatabaseMockController.admins.get(i).getIdAdmin() == id) {
                DatabaseMockController.admins.set(i, dataBaru);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return DatabaseMockController.admins.removeIf(f -> f.getIdAdmin() == id);
    }
}