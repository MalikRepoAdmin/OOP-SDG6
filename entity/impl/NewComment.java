package entity.impl;

import java.time.LocalDate;
import java.util.Map;

import database.Database;
import entity.AbstractComment;


public class NewComment extends AbstractComment {
    private Database database;

    // Constructor 
    public NewComment(Database database){
        this.database = database;
    }

    @Deprecated
    @Override
    public void updateComment(String comment){}

    @Override
    public void addComment(String comment,String userId){
        super.commentId = commentCount + 1;
        super.commentContent = comment;
        super.userId = userId;
        super.commentCreatedDate = addDate();

        commentCount = commentId;
    }

    private LocalDate addDate(){

        LocalDate nowDate = LocalDate.now();
        return nowDate;
    }

    @Override
    public void displaySendedComment(){
        String commentIdString = String.valueOf(commentId);
        Map<String, Object> commentColumn = database.getOneComment(commentIdString);

        System.out.printf("%n"+ "Sended Comment: %n" +
            "ID User: %s %n"+
            "ID Comment: %s %n"+
            "Comment: %s %n"+
            "Created Date: %s %n"+
            "Modified Date: %s %n %n",
            commentColumn.get("id_user"),
            commentColumn.get("id_komentar"),
            commentColumn.get("isi_komentar"),
            commentColumn.get("tgl_dibuat"),
            commentColumn.get("tgl_modified"));
    }

    @Override
    public void sendComment(){
        System.out.println("Sending New Comment...");
        
        database.createTo_komentar(super.userId, super.commentContent, super.commentCreatedDate);
    }

    @Override
    public void displayComment(){
        String dateString = commentCreatedDate.toString();

        System.out.printf("%n"+ "New Comment: %n" +
            "ID User: %s %n"+
            "ID Comment: %s %n"+
            "Comment: %s %n"+
            "Created Date: %s %n %n",
            super.userId,super.commentId,super.commentContent,dateString);
    }

    @Override
    public int getCommentID(){
        return super.commentId;
    }
}
