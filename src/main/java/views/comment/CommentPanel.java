package views.comment;

import views.base.BaseCrudPanel;
import views.base.BaseFormDialog;
import views.base.BaseTableModel;
import views.utils.DialogUtil;
import views.validator.GlobalExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.time.LocalDate;

public class CommentPanel extends BaseCrudPanel {

    private final BaseTableModel tableModel;
    private final List<Object[]> dummyData;

    private CommentAddRequest commentAddRequest = new CommentAddRequest();
    private Map<String, String> commentAddErrors;

    private CommentEditRequest CommentEditRequest = new CommentEditRequest();
    private Map<String, String> commentEditErrors;


    public CommentPanel() {

        dummyData = new ArrayList<>();

        tableModel = new CommentTableModel();

        setTableModel(tableModel);

        initializeDummyData();

        initializeActions();
    }


    private void initializeDummyData() {

        dummyData.add(new Object[] {
                1,
                "001",
                "John Doe",
                "Sungai Bengawan Solo cukup bersih kalo saya liat",
                LocalDate.now().toString(),
                LocalDate.now().toString(),
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

        BaseFormDialog dialog = new CommentAddFormDialog();

        dialog.setOnSave(() -> {

            Map<String, String> values = dialog.getFormValues();

            String valuesIdUser = values.get("ID User");
            String valuesNamaUser = values.get("Nama User");
            String valuesIsiKomentar = values.get("Komentar");
            String valuesTanggalDibuat = LocalDate.now().toString();
            String valuesTanggalDiubah = LocalDate.now().toString();

            // JAKARTA VALIDATION
            this.commentAddRequest.setIdUser(valuesIdUser);
            this.commentAddRequest.setNamaUser(valuesNamaUser);
            this.commentAddRequest.setIsiKomentar(valuesIsiKomentar);
            this.commentAddRequest.setTanggalCreated(valuesTanggalDibuat);

            this.commentAddErrors = GlobalExceptionHandler.handleValidation(this.commentAddRequest);
                if (!this.commentAddErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.commentAddErrors.containsKey("idUser")) {
                        DialogUtil.showError(null, "Error ID User: " + this.commentAddErrors.get("idUser"));
                    }
                    if (this.commentAddErrors.containsKey("namaUser")) {
                        DialogUtil.showError(null, "Error Nama User: " + this.commentAddErrors.get("namaUser"));
                    }
                    if (this.commentAddErrors.containsKey("isiKomentar")) {
                        DialogUtil.showError(null, "Error Isi Komentar: " + this.commentAddErrors.get("isiKomentar"));
                    }

                    return;
                } else {
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                    dummyData.size() + 1,
                    valuesIdUser,
                    valuesNamaUser,
                    valuesIsiKomentar,
                    valuesTanggalDibuat,
                    valuesTanggalDiubah,
            };

            dummyData.add(row);

            tableModel.setRows(dummyData);

            DialogUtil.showSuccess(dialog, "Data berhasil ditambahkan");

            dialog.dispose();
        });

        dialog.setVisible(true);
    }


    // TODO: this method still create new record. not edit
    private void showEditDialog() {

        int selectedRow;
        BaseFormDialog dialog = new CommentEditFormDialog();


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

            // Get Values from selected row
            Object valuesIdKomentar = tableModel.getValueAt(selectedRow, 0);
            Object valuesIdUser = tableModel.getValueAt(selectedRow, 1);
            Object valuesNamaUser = tableModel.getValueAt(selectedRow, 2);
            Object valuesTanggalDibuat = tableModel.getValueAt(selectedRow, 4);

            Map<String, String> values = dialog.getFormValues();

            String valuesIsiKomentar = values.get("Komentar");
            String valuesTanggalDiubah = LocalDate.now().toString();

            // JAKARTA VALIDATION
            this.CommentEditRequest.setIsiKomentar(valuesIsiKomentar);;
            this.CommentEditRequest.setTanggalModified(valuesTanggalDiubah);

            this.commentEditErrors = GlobalExceptionHandler.handleValidation(this.CommentEditRequest);
                if (!this.commentEditErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.commentEditErrors.containsKey("isiKomentar")) {
                        DialogUtil.showError(null, "Error Isi Komentar: " + this.commentEditErrors.get("isiKomentar"));
                    }
                    if (this.commentEditErrors.containsKey("tanggalModified")) {
                        DialogUtil.showError(null, "Error Tanggal Diubah: " + this.commentEditErrors.get("tanggalModified"));
                    }

                    return;
                } else {
                    // JIKA AMAN: Lanjutkan proses Register
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                valuesIdKomentar,
                valuesIdUser,
                valuesNamaUser,
                valuesIsiKomentar,
                valuesTanggalDibuat,
                valuesTanggalDiubah,
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