package views.kategori;

import views.base.BaseFormDialog;

public class KategoriSungaiFormDialog
        extends BaseFormDialog {

    public KategoriSungaiFormDialog() {

        super(
                null,
                "Form Kategori Sungai",
                new String[] {
                        "Nama Kategori",
                        "Deskripsi"
                }
        );
    }
}