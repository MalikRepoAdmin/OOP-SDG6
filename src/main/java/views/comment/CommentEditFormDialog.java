package views.comment;

import java.util.Map;

import views.base.BaseFormDialog;

public class CommentEditFormDialog extends BaseFormDialog{

	public CommentEditFormDialog() {

        super(
                null,
                "Form Ubah Comment",
                new String[] {
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