package views.databaru;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class DataBaruPanel extends BaseCrudPanel {

    public DataBaruPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "Nama Data",
                "Tanggal",
                "Status"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Data Sungai Baru",
                "2026-05-19",
                "Pending"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}