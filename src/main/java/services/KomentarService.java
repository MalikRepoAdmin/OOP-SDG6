package services;

import java.util.ArrayList;
import java.util.List;

import database.impl.DatabaseMockController;
import entity.impl.NewComment;

public class KomentarService {

    public void addKomentar(NewComment k) {
        DatabaseMockController.komentarList.add(k);
        DatabaseMockController.commentIdCounter += 1;
    }

    public List<NewComment> getById(int komentarId) {
        List<NewComment> result = new ArrayList<>();
        for (NewComment k : DatabaseMockController.komentarList) {
            if (k.getCommentId() == komentarId) {
                result.add(k);
            }
        }
        return result;
    }

    public boolean update(int id, NewComment dataBaru) {
        for (int i = 0; i < DatabaseMockController.komentarList.size(); i++) {
            if (DatabaseMockController.komentarList.get(i).getCommentId() == id) {
                DatabaseMockController.komentarList.set(i, dataBaru);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return DatabaseMockController.komentarList.removeIf(k -> k.getCommentId() == id);
    }
}