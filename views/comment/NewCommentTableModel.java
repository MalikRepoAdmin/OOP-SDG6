package views.comment;

import views.base.BaseTableModel;

public class NewCommentTableModel extends BaseTableModel {

    public NewCommentTableModel() {

        super(
                new String[] {
                        "ID",
                        "Komentar Baru",
                        "Pengguna"
                }
        );
    }
}