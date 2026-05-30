package views.admin;

import views.base.BaseTableModel;

public class AdminTableModel extends BaseTableModel {

    public AdminTableModel() {

        super(new String[] {
                "ID",
                "Nama Admin",
                "Email",
                "Level"
        });
    }
}