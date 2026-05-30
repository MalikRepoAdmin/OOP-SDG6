package views.user;

import views.base.BaseFormDialog;

public class UserFormDialog extends BaseFormDialog {

    public UserFormDialog() {

        super(
                null,
                "Form User",
                new String[] {
                        "Nama",
                        "Email",
                        "Role"
                }
        );
    }
}