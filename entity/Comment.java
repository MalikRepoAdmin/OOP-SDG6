package entity;

// Open/Closed Principle
// Interface Segregation Principle
/// Interface Untuk menambah jenis comment baru(sub-class)
public interface Comment {
    void sendComment();
    void displayComment();
    int getCommentID();
}
