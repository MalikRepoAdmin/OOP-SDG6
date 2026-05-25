package views.admin;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class AdminPanel extends BaseCrudPanel {

    public AdminPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "Nama Admin",
                "Email",
                "Level"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Super Admin",
                "superadmin@mail.com",
                "ROOT"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}