package views.sungai;

import views.base.BaseCrudPanel;
import views.base.BaseFormDialog;
import views.base.BaseTableModel;
import views.utils.DialogUtil;
import views.utils.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Example implementation.
 *
 * This panel does NOT depend on database.
 * Data is temporary for UI testing.
 */
public class SungaiPanel extends BaseCrudPanel {

    private final BaseTableModel tableModel;

    private final List<Object[]> dummyData;

    public SungaiPanel() {

        dummyData = new ArrayList<>();

        tableModel = new BaseTableModel(new String[] {
                "ID",
                "Nama Sungai",
                "Kategori",
                "Status"
        });

        setTableModel(tableModel);

        initializeDummyData();

        initializeActions();
    }

    private void initializeDummyData() {

        dummyData.add(new Object[] {
                1,
                "Sungai Bengawan Solo",
                "Utama",
                "Bersih"
        });

        tableModel.setRows(dummyData);
    }

    private void initializeActions() {

        setOnAdd(this::showAddDialog);

        setOnDelete(this::deleteSelectedData);
    }

    private void showAddDialog() {

        BaseFormDialog dialog = new SungaiAddFormDialog();

        dialog.setOnSave(() -> {

            Map<String, String> values = dialog.getFormValues();

            if (ValidationUtil.hasEmptyField(values)) {

                DialogUtil.showError(dialog, "Semua field wajib diisi");
                return;
            }

            Object[] row = new Object[] {
                    dummyData.size() + 1,
                    values.get("Nama Sungai"),
                    values.get("Kategori"),
                    values.get("Status")
            };

            dummyData.add(row);

            tableModel.setRows(dummyData);

            DialogUtil.showSuccess(dialog, "Data berhasil ditambahkan");

            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    private void deleteSelectedData() {

        int selectedRow = table.getSelectedRow();

        if (selectedRow < 0) {

            DialogUtil.showError(this, "Pilih data terlebih dahulu");
            return;
        }

        boolean confirmed = DialogUtil.showConfirm(
                this,
                "Yakin ingin menghapus data?"
        );

        if (!confirmed) {
            return;
        }

        dummyData.remove(selectedRow);

        tableModel.setRows(dummyData);
    }
}