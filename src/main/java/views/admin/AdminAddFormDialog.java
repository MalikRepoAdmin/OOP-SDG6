package views.admin;

import views.base.BaseFormDialog;

public class AdminAddFormDialog extends BaseFormDialog {

    public AdminAddFormDialog() {

        super(
                null,
                "Form Tambah Admin",
                new String[] {
                        "Nama Admin",
                        "Email",
                        "Password",
                        "Tanggal Lahir",
                        "Pekerjaan",
                        "Bio",
                        "Domisili"
                }
        );

        replaceField("Tanggal Lahir", createDateField());
    }
}