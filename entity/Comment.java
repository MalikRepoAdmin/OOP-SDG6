package entity;

/// Interface Untuk menambah jenis comment baru(sub-class)
public interface Comment {
    void sendComment();
    void displayComment();
    int getCommentID();

    void addComment(String comment,String userId);
    void updateComment(String comment);
}
