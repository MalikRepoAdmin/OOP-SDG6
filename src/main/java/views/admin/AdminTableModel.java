package views.admin;

import views.base.BaseTableModel;

public class AdminTableModel extends BaseTableModel {

    public AdminTableModel() {

        super(new String[] {
                "ID Admin",
                "ID User",
                "Nama Admin",
                "Email",
                "Password",
                "Tanggal Lahir",
                "Pekerjaan",
                "Bio",
                "Domisili",
        });
    }
}