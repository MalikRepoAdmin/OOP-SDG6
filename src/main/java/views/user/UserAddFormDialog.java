package views.user;

import views.base.BaseFormDialog;

public class UserAddFormDialog extends BaseFormDialog {

    public UserAddFormDialog() {

        super(
                null,
                "Form Tambah User",
                new String[] {
                        "Nama User",
                        "Email",
                        "Password",
                        "Pekerjaan",
                        "Bio",
                        "Domisili"
                }
        );
    }
}