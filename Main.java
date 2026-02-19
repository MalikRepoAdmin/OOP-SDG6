import database.Database;
import database.impl.DatabaseMock;
import entity.AbstractComment;
import entity.impl.NewComment;
import entity.impl.OldComment;

/// Entry Point
public class Main {
    public static void main(String[] args) {
        System.out.println("Ini adalah program untuk test Entitas Comment\n\n");

        // Instantiate DatabaseMock
        Database newDatabase = new DatabaseMock();

        // Instantiate NewComment
        AbstractComment newComment = new NewComment();
        newComment.addComment("Hello, World!", "254311011");
        newComment.sendComment(newDatabase);
        newComment.displayComment();
        newComment.displayCount();

        String commentId = String.valueOf(newComment.getCommentID());

        // Instantiate OldComment
        AbstractComment oldComment = new OldComment(newDatabase, commentId);
        oldComment.displayComment();
        oldComment.updateComment("Good Night, World...");
        oldComment.sendComment(newDatabase);
        oldComment.displaySendedComment();

        
    }

}
