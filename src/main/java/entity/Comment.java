package entity;

// Konsep Polimorfisme (Interface sebagai kontrak basis komponen komentar)
public interface Comment {
    void sendComment();
    void displayComment();
    int getCommentId();
}
