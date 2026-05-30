package views.comment;

import java.util.Map;

import views.base.BaseFormDialog;

public class CommentAddFormDialog extends BaseFormDialog {

    public CommentAddFormDialog() {

        super(
                null,
                "Form Buat Comment",
                new String[] {
                        "ID User",
                        "Nama User",
                        "Komentar",
                }
        );
    }

    private void initializeActions() {

        setOnSave(() -> {

            Map<String, String> values =
                    getFormValues();

            dispose();
        });
    }
}