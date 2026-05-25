package views.status;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class StatusSungaiPanel extends BaseCrudPanel {

    public StatusSungaiPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "Nama Status",
                "Keterangan"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Bersih",
                "Kondisi air baik"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}