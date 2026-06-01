package entity.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import database.Database;
import entity.AbstractComment;
import entity.ICommentCreator;

// Single Resposibility  Principle 
// Dependency Inversion Principle
public class NewComment extends AbstractComment implements ICommentCreator {

    private Database database;

    // Constructor 
    public NewComment(Database database) {
        super();
        this.database = database;
    }

    // Interface Segregation Principle: FIXED
    @Override
    public void addComment(String comment, String userId) {
        super.commentId = commentCount + 1;
        super.commentContent = comment;

        try {
            Integer.valueOf(userId);
            super.userId = userId;
        } catch (NumberFormatException e) {
            System.err.println("Warning! userId must be whole number");
        }
        super.commentCreatedDate = addDate();

        commentCount = commentId;
    }

    private LocalDate addDate() {

        LocalDate nowDate = LocalDate.now();
        return nowDate;
    }

    // Liskov Subtitution Principle
    @Override
    public void displaySendedComment() {
        String commentIdString = String.valueOf(commentId);
        Map<String, Object> commentColumn = database.getOneComment(commentIdString);
        ArrayList<String> verifiedColumn = new ArrayList<>();

        try {
            String[] keysToFind = {"id_user", "id_komentar", "isi_komentar", "tgl_dibuat", "tgl_modified"};

            for (String key : keysToFind) {
                if (!commentColumn.containsKey(key)) {
                    System.err.println("\nThe column '" + key + "' does not exist on the database");
                }

                verifiedColumn.add(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("%n" + "Sended Comment: %n"
                + "ID User: %s %n"
                + "ID Comment: %s %n"
                + "Comment: %s %n"
                + "Created Date: %s %n"
                + "Modified Date: %s %n %n",
                commentColumn.get(verifiedColumn.get(0)),
                commentColumn.get(verifiedColumn.get(1)),
                commentColumn.get(verifiedColumn.get(2)),
                commentColumn.get(verifiedColumn.get(3)),
                commentColumn.get(verifiedColumn.get(4)));
    }

    @Override
    public void sendComment() {
        System.out.println("Sending New Comment...");

        database.createTo_komentar(super.userId, super.commentContent, super.commentCreatedDate);
    }

    @Override
    public void displayComment() {
        String dateString = commentCreatedDate.toString();

        System.out.printf("%n" + "New Comment: %n"
                + "ID User: %s %n"
                + "ID Comment: %s %n"
                + "Comment: %s %n"
                + "Created Date: %s %n %n",
                super.userId, super.commentId, super.commentContent, dateString);
    }

    @Override
    public int getCommentId() {
        return super.commentId;
    }

    public int getCommentID() {
        return getCommentId();
    }
}
