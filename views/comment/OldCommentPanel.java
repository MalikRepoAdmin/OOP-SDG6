package views.comment;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class OldCommentPanel extends BaseCrudPanel {

    public OldCommentPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "Komentar Lama",
                "Pengguna"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Sungai masih aman",
                "Admin"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}