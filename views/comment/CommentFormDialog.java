package views.comment;

import views.base.BaseFormDialog;

public class CommentFormDialog
        extends BaseFormDialog {

    public CommentFormDialog() {

        super(
                null,
                "Form Comment",
                new String[] {
                        "Nama User",
                        "Komentar",
                        "Tanggal"
                }
        );
    }
}