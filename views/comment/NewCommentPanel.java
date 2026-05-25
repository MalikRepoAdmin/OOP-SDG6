package views.comment;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class NewCommentPanel extends BaseCrudPanel {

    public NewCommentPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "Komentar Baru",
                "Pengguna"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Air sungai mulai keruh",
                "Malik"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}