package views.status;

import views.base.BaseFormDialog;

public class StatusSungaiFormDialog
        extends BaseFormDialog {

    public StatusSungaiFormDialog() {

        super(
                null,
                "Form Status Sungai",
                new String[] {
                        "Nama Status",
                        "Keterangan"
                }
        );
    }
}