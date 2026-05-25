package views.admin;

import views.base.BaseFormDialog;

public class AdminFormDialog extends BaseFormDialog {

    public AdminFormDialog() {

        super(
                null,
                "Form Admin",
                new String[] {
                        "Nama Admin",
                        "Email",
                        "Level"
                }
        );
    }
}