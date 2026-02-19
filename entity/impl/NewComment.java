package entity.impl;

import java.time.LocalDate;
import database.Database;
import entity.AbstractComment;


public class NewComment extends AbstractComment {
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
    public void sendComment(Database database){
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
