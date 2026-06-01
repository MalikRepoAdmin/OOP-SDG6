package views.user;

import views.base.BaseFormDialog;

public class UserEditFormDialog extends BaseFormDialog{
    
    public UserEditFormDialog() {

        super(
                null,
                "Form Edit User",
                new String[] {
                        "Nama User",
                        "Tanggal Lahir",
                        "Pekerjaan",
                        "Bio",
                        "Domisili"
                }
        );

        replaceField("Tanggal Lahir", createDateField());
    }
}
