package entity;

import java.time.LocalDate;

// Open/Closed Principle
// Liskov Subtitution Principle
/// Class Comment (Parent) : Di Instatiate di Class CliApp 
public abstract class AbstractComment implements Comment{
    protected static int commentCount = 0;

    protected int commentId;
    protected String commentContent;
    protected LocalDate commentCreatedDate;
    protected LocalDate commentModifiedDate;
    
    protected String userId;

    public final void displayCount(){
        System.out.println("Comment Count: "+commentCount+"\n\n");
    }

    public abstract void displaySendedComment();
}
