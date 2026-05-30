package views.user;

import views.base.BaseTableModel;

public class UserTableModel extends BaseTableModel {

    public UserTableModel() {

        super(new String[] {
                "ID",
                "Nama",
                "Email",
                "Role"
        });
    }
}