package services;

import java.util.List;

import database.impl.DatabaseMockController;
import entity.User;

public class UserService {
    
    public void create(User f) {
        DatabaseMockController.users.add(f);
        DatabaseMockController.userIdCounter += 1;
    }

    public List<User> getAll() {
        return DatabaseMockController.users;
    }

    public boolean update(int id, User dataBaru) {
        for (int i = 0; i < DatabaseMockController.users.size(); i++) {
            if (DatabaseMockController.users.get(i).getIdUser() == id) {
                DatabaseMockController.users.set(i, dataBaru);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return DatabaseMockController.users.removeIf(f -> f.getIdUser() == id);
    }
}
