package services;

import java.util.List;

import database.impl.DatabaseMockController;
import entity.Sungai;

public class SungaiService {

    public void create(Sungai s) {
        DatabaseMockController.sungaiList.add(s);
        DatabaseMockController.sungaiIdCounter += 1;
    }

    public List<Sungai> getAll() {
        return DatabaseMockController.sungaiList;
    }

    public Sungai getById(int id) {
        for (Sungai s : DatabaseMockController.sungaiList) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public boolean update(int id, Sungai dataBaru) {
        for (int i = 0; i < DatabaseMockController.sungaiList.size(); i++) {
            if (DatabaseMockController.sungaiList.get(i).getId() == id) {
                DatabaseMockController.sungaiList.set(i, dataBaru);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return DatabaseMockController.sungaiList.removeIf(s -> s.getId() == id);
    }
}