package entity;

import java.time.LocalDate;


/// Class Comment (Parent) : Di Instatiate di Class CliApp 
public abstract class AbstractComment implements Comment{
    protected static int commentCount = 0;

    protected int commentId;
    protected String commentContent;
    protected LocalDate commentCreatedDate;
    protected LocalDate commentModifiedDate;
    
    protected String userId;

    public void displayCount(){
        System.out.println("Comment Count: "+commentCount+"\n\n");
    }

    public void displaySendedComment(){};
}
