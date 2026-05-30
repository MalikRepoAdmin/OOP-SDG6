package views.kategori;

import views.base.BaseTableModel;

public class KategoriSungaiTableModel
        extends BaseTableModel {

    public KategoriSungaiTableModel() {

        super(
                new String[] {
                        "ID",
                        "Nama Kategori",
                        "Deskripsi"
                }
        );
    }
}