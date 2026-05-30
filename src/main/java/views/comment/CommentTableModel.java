package views.comment;

import views.base.BaseTableModel;

public class CommentTableModel extends BaseTableModel {

    public CommentTableModel() {

        super(
                new String[] {
                        "ID",
                        "ID User",
                        "Nama User",
                        "Komentar",
                        "Tanggal Dibuat",
                        "Tanggal Diubah",
                }
        );
    }
}