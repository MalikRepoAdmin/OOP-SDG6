package views.comment;

import views.base.BaseTableModel;

public class OldCommentTableModel extends BaseTableModel {

    public OldCommentTableModel() {

        super(
                new String[] {
                        "ID",
                        "Komentar Lama",
                        "Pengguna"
                }
        );
    }
}