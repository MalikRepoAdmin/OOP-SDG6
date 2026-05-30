package views.databaru;

import views.base.BaseFormDialog;

public class DataBaruFormDialog
        extends BaseFormDialog {

    public DataBaruFormDialog() {

        super(
                null,
                "Form Data Baru",
                new String[] {
                        "Nama Data",
                        "Tanggal",
                        "Status"
                }
        );
    }
}