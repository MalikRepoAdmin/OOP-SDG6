package views.kategori;

import views.base.BaseCrudPanel;
import views.base.BaseTableModel;

import java.util.ArrayList;
import java.util.List;

public class KategoriSungaiPanel extends BaseCrudPanel {

    public KategoriSungaiPanel() {

        BaseTableModel model = new BaseTableModel(new String[] {
                "ID",
                "Nama Kategori",
                "Deskripsi"
        });

        List<Object[]> rows = new ArrayList<>();

        rows.add(new Object[] {
                1,
                "Utama",
                "Kategori sungai utama"
        });

        model.setRows(rows);

        setTableModel(model);
    }
}