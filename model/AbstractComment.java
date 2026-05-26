package model;

import java.time.LocalDate;

// Konsep Polimorfisme & Abstraksi (Abstract class induk penampung properti murni)
public abstract class AbstractComment implements Comment {
    // Properti statis pelacak jumlah objek
    protected static int commentCount = 0;
    
    // Properti dasar enkapsulasi dengan modifier protected
    protected int commentId;
    protected String commentContent;
    protected LocalDate commentCreatedDate;
    protected LocalDate commentModifiedDate;
    protected String userId;

    // Constructor induk pemegang data instansiasi
    public AbstractComment(int commentId, String commentContent, LocalDate commentCreatedDate, String userId) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentCreatedDate = commentCreatedDate;
        this.commentModifiedDate = commentCreatedDate;
        this.userId = userId;
        commentCount++;
    }

    public final void displayCount() {
        System.out.println("Comment Count: " + commentCount + "\n\n");
    }

    // Method abstrak blueprint aksi subclass anak
    public abstract void displaySendedComment();
}
