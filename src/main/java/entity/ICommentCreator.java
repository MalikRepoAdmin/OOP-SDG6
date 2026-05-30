package entity;

//Konsep Interface Segregation Principle (kontrak aksi yg terisolasi khusus pembuatan data
public interface ICommentCreator {
    void addComment(String comment,String userId);
}
