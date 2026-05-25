package views.status;

import views.base.BaseTableModel;

public class StatusSungaiTableModel
        extends BaseTableModel {

    public StatusSungaiTableModel() {

        super(
                new String[] {
                        "ID",
                        "Nama Status",
                        "Keterangan"
                }
        );
    }
}