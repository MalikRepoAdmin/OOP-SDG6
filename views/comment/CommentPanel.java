package views.comment;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class CommentPanel extends BaseCrudPanel {

    public CommentPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "User",
                "Komentar",
                "Tanggal"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Malik",
                "Sungai terlihat bersih",
                "2026-05-19"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}