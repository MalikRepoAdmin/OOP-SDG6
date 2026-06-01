package views.admin;

import views.base.BaseFormDialog;

public class AdminEditFormDialog extends BaseFormDialog {
    
    public AdminEditFormDialog() {

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
