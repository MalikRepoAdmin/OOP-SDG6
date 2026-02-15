package entity;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestComment {
    public static void main(String[] args) {
        System.out.println("Ini adalah program untuk test Entitas Comment");
    }

    Comment newComment = new Comment(); 
    
}

class Comment {
    protected static int commentCount = 0;

    protected int commentId;
    protected String commentContent;
    protected LocalDate commentDate;
    
    protected String userId;

    public void displayCount(){
        System.out.println("Comment Count: "+commentCount);
    }
}

interface CommentType {
    void sendComment();
    void displayComment();
}

class NewComment extends Comment implements CommentType {
    public void addComment(String comment,String userId){
        this.commentContent = comment;
        this.userId = userId;
        this.commentDate = addDate();

        commentCount++;

        System.out.println(commentContent);
        System.out.println(userId);
        System.out.println("comment count: "+ commentCount);
    }

    private LocalDate addDate(){

        LocalDate nowDate = LocalDate.now();
        return nowDate;
    }

    @Override
    public void sendComment(){
        System.out.println("Sending Comment...");
    }

    @Override
    public void displayComment(){
        String dateString = commentDate.toString();

        System.out.printf(
            "ID User: %s %n"+
            "ID Comment: %s %n"+
            "Comment: %s %n"+
            "Date: %s %n",
            userId,commentId,commentContent,dateString);
    }
}

class OldComment  extends Comment implements CommentType {
    public void updateComment(String comment,String userId){
        this.commentContent = comment;
        this.userId = userId;
        this.commentDate = addDate();

        commentCount++;

        System.out.println(commentContent);
        System.out.println(userId);
        System.out.println("comment count: "+ commentCount);
    }

    private LocalDate addDate(){

        LocalDate nowDate = LocalDate.now();
        return nowDate;
    }

    @Override
    public void sendComment(){
        System.out.println("Sending Comment...");
    }

    @Override
    public void displayComment(){
        String dateString = commentDate.toString();

        System.out.printf(
            "ID User: %s %n"+
            "ID Comment: %s %n"+
            "Comment: %s %n"+
            "Modified Date: %s %n",
            userId,commentId,commentContent,dateString);
    }
}


interface Database {
    void getConnection(String DB_URL, String USER, String PASSWORD);

    void createToDB();
    void updateToDB();
    void deleteToDB();

    String getOneComment();
    String getAllComment();
    
}

class DatabaseMysql implements Database{

    private static Connection DB_CONNECTION = null;

    @Override
    public void getConnection(String DB_URL, String USER, String PASSWORD) {
        try {
            DB_CONNECTION = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void createToDB(){
        String query = "INSERT INTO tbl_komentar (id_user, isi_komentar, tgl_dibuat) VALUES (?,?,?)";

        try {
            PreparedStatement pStatement = DB_CONNECTION.prepareStatement(query);
            pStatement.setString(1, query);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}