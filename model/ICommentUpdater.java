package model;

// Interface Segregation Principle (Kontrak aksi terisolasi khusus pembaruan data)
public interface ICommentUpdater {
    public void updateComment(String comment);
}
