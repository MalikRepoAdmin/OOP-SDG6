package views.databaru;

import views.base.BaseTableModel;

public class DataBaruTableModel
        extends BaseTableModel {

    public DataBaruTableModel() {

        super(
                new String[] {
                        "ID",
                        "Nama Data",
                        "Tanggal",
                        "Status"
                }
        );
    }
}