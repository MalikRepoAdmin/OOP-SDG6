package entity.impl;

import java.time.LocalDate;
import database.Database;
import entity.AbstractComment;
import java.util.Map;

public class OldComment  extends AbstractComment {
    private static Map<String, Object> fetchedComment;
    private Database database;

    // Constructor
    public OldComment(Database database, String commentId){
        fetchedComment = database.getOneComment(commentId);
        this.database = database;

        super.commentId = (int) fetchedComment.get("id_komentar");
        super.userId = (String) fetchedComment.get("id_user");
        super.commentContent = (String) fetchedComment.get("isi_komentar");
        super.commentCreatedDate = (LocalDate) fetchedComment.get("tgl_dibuat");
        super.commentModifiedDate = null;
    }


    @Deprecated
    @Override
    public void addComment(String comment,String userId){}

    /** 
     * @deprecated use Constructor instead
     */
    @Override
    @Deprecated
    public void updateComment(String comment){
        super.commentContent = comment;
        super.commentModifiedDate = addDate();
    }

    private LocalDate addDate(){

        LocalDate nowDate = LocalDate.now();
        return nowDate;
    }

    @Override
    public void sendComment(){
        System.out.println("Sending Updated Comment...");
        
        database.updateTo_komentar(String.valueOf(super.commentId), super.commentContent, super.commentModifiedDate);
    }

    @Override
    public void displaySendedComment(){
        String commentIdString = String.valueOf(commentId);
        Map<String, Object> commentColumn = database.getOneComment(commentIdString);

        System.out.printf("%n"+ "Updated Comment: %n" +
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
    public void displayComment(){
        String createdDate = commentCreatedDate.toString();

        System.out.printf("%n"+ "Old Comment: %n" +
            "ID User: %s %n"+
            "ID Comment: %s %n"+
            "Comment: %s %n"+
            "Created Date: %s %n"+
            "Modified Date: %s %n %n",
            userId,commentId,commentContent,createdDate,this.commentModifiedDate);
    }


    @Override
    public int getCommentID(){
        return super.commentId;
    }
}
