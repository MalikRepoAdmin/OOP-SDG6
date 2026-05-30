package views.sungai;

import views.base.BaseCrudPanel;
import views.base.BaseFormDialog;
import views.base.BaseTableModel;
import views.utils.DialogUtil;
import views.validator.GlobalExceptionHandler;

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

    private SungaiAddRequest sungaiAddRequest = new SungaiAddRequest();
    private Map<String, String> sungaiAddErrors;

    private SungaiEditRequest sungaiEditRequest = new SungaiEditRequest();
    private Map<String, String> sungaiEditErrors;


    public SungaiPanel() {

        dummyData = new ArrayList<>();

        tableModel = new SungaiTableModel();

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

        setOnEdit(this::showEditDialog);

        setOnDelete(this::deleteSelectedData);

        setOnRefresh(this::refreshTable);
    }

    private void showAddDialog() {

        BaseFormDialog dialog = new SungaiAddFormDialog();

        dialog.setOnSave(() -> {

            Map<String, String> values = dialog.getFormValues();

            String valuesNamaSungai = values.get("Nama Sungai");
            String valuesKategori = values.get("Kategori");
            String valuesStatus = values.get("Status");

            // JAKARTA VALIDATION
            this.sungaiAddRequest.setNamaSungai(valuesNamaSungai);
            this.sungaiAddRequest.setKategori(valuesKategori);
            this.sungaiAddRequest.setStatus(valuesStatus);

            this.sungaiAddErrors = GlobalExceptionHandler.handleValidation(this.sungaiAddRequest);
                if (!this.sungaiAddErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.sungaiAddErrors.containsKey("namaSungai")) {
                        DialogUtil.showError(null, "Error Nama Sungai: " + this.sungaiAddErrors.get("namaSungai"));
                    }
                    if (this.sungaiAddErrors.containsKey("status")) {
                        DialogUtil.showError(null, "Error Status: " + this.sungaiAddErrors.get("status"));
                    }

                    return;
                } else {
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                    dummyData.size() + 1,
                    valuesNamaSungai,
                    valuesKategori,
                    valuesStatus,
            };

            dummyData.add(row);

            tableModel.setRows(dummyData);

            DialogUtil.showSuccess(dialog, "Data berhasil ditambahkan");

            dialog.dispose();
        });

        dialog.setVisible(true);
    }


    private void showEditDialog() {

        int selectedRow;
        BaseFormDialog dialog = new SungaiEditFormDialog();


        // Data Selection Validation
        try {
            // Return -1 if no row selected, triggering indexoutofbound exception
            selectedRow = table.getSelectedRow();

            // This trigger IndexOutOfBound exception
            Object[] data = tableModel.getRow(selectedRow);

        } catch (IndexOutOfBoundsException e) {
            
            DialogUtil.showError(this, "Pilih data terlebih dahulu");
            return;
        }


        dialog.setOnSave(() -> {

            boolean confirmed = DialogUtil.showConfirm(
                this,
                "Yakin ingin memperbarui data?"
            );

            if (!confirmed) {
                return;
            }

            Map<String, String> values = dialog.getFormValues();

            String valuesNamaSungai = values.get("Nama Sungai");
            String valuesKategori = values.get("Kategori");
            String valuesStatus = values.get("Status");

            // JAKARTA VALIDATION
            this.sungaiEditRequest.setNamaSungai(valuesNamaSungai);
            this.sungaiEditRequest.setKategori(valuesKategori);
            this.sungaiEditRequest.setStatus(valuesStatus);

            this.sungaiEditErrors = GlobalExceptionHandler.handleValidation(this.sungaiEditRequest);
                if (!this.sungaiEditErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.sungaiEditErrors.containsKey("namaSungai")) {
                        DialogUtil.showError(null, "Error Nama Sungai: " + this.sungaiEditErrors.get("namaSungai"));
                    }
                    if (this.sungaiEditErrors.containsKey("status")) {
                        DialogUtil.showError(null, "Error Status: " + this.sungaiEditErrors.get("status"));
                    }

                    return;
                } else {
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                    dummyData.size() + 1,
                    valuesNamaSungai,
                    valuesKategori,
                    valuesStatus,
            };

            dummyData.set(selectedRow, row);

            tableModel.setRows(dummyData);

            DialogUtil.showSuccess(dialog, "Data berhasil diperbarui");

            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    private void deleteSelectedData() {

        try {
            // Return -1 if no row selected, triggering indexoutofbound exception
            int selectedRow = table.getSelectedRow();

            // This trigger IndexOutOfBound exception
            Object[] data = tableModel.getRow(selectedRow);

            boolean confirmed = DialogUtil.showConfirm(
                this,
                "Yakin ingin menghapus data?"
            );

            if (!confirmed) {
                return;
            }

            dummyData.remove(selectedRow);

            tableModel.setRows(dummyData);
        } catch (IndexOutOfBoundsException e) {
            
            DialogUtil.showError(this, "Pilih data terlebih dahulu");
            return;
        }
    }

    private void refreshTable() {

        table.clearSelection();
        tableModel.setRows(dummyData);
    }
}