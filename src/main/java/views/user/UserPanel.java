package views.user;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class UserPanel extends BaseCrudPanel {

    public UserPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "Nama",
                "Email",
                "Role"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Admin",
                "admin@mail.com",
                "Administrator"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}