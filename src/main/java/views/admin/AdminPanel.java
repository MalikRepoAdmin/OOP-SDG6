package views.admin;

import views.base.BaseCrudPanel;
import views.base.BaseFormDialog;
import views.base.BaseTableModel;
import views.user.UserAddFormDialog;
import views.user.UserAddRequest;
import views.user.UserEditFormDialog;
import views.user.UserEditRequest;
import views.user.UserTableModel;
import views.utils.DialogUtil;
import views.validator.GlobalExceptionHandler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AdminPanel extends BaseCrudPanel {

    private final BaseTableModel tableModel;
    private final List<Object[]> dummyData;

    private AdminAddRequest adminAddRequest = new AdminAddRequest();
    private Map<String, String> adminAddErrors;

    private AdminEditRequest adminEditRequest = new AdminEditRequest();
    private Map<String, String> adminEditErrors;

    public AdminPanel() {

        dummyData = new ArrayList<>();

        tableModel = new AdminTableModel();

        setTableModel(tableModel);

        initializeDummyData();

        initializeActions();
    }

    private void initializeDummyData() {

        dummyData.add(new Object[] {
                1,
                1,
                "Malik",
                "malik@gmail.com",
                "123456",
                LocalDate.of(2007, 5, 21).toString(),
                "Mahasiswa",
                "",
                "Kota Madiun"
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

        BaseFormDialog dialog = new AdminAddFormDialog();

        dialog.setOnSave(() -> {

            Map<String, String> values = dialog.getFormValues();

            String valuesNamaAdmin = values.get("Nama Admin");
            String valuesEmail = values.get("Email");
            String valuesPassword = values.get("Password");

            Date spinnerDate = (Date) dialog.getCustomFieldValue("Tanggal Lahir");
            String valuesTanggalLahir = spinnerDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
            String valuesPekerjaan = values.get("Pekerjaan");
            String valuesBio = values.get("Bio");
            String valuesDomisili = values.get("Domisili");

            // JAKARTA VALIDATION
            this.adminAddRequest.setNamaAdmin(valuesNamaAdmin);
            this.adminAddRequest.setEmail(valuesEmail);
            this.adminAddRequest.setPassword(valuesPassword);
            this.adminAddRequest.setTanggalLahir(valuesTanggalLahir);
            this.adminAddRequest.setPekerjaan(valuesPekerjaan);
            this.adminAddRequest.setBio(valuesBio);
            this.adminAddRequest.setDomisili(valuesDomisili);

            this.adminAddErrors = GlobalExceptionHandler.handleValidation(this.adminAddRequest);
                if (!this.adminAddErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.adminAddErrors.containsKey("namaAdmin")) {
                        DialogUtil.showError(null, "Error Nama Admin: " + this.adminAddErrors.get("namaAdmin"));
                    }
                    if (this.adminAddErrors.containsKey("email")) {
                        DialogUtil.showError(null, "Error Email: " + this.adminAddErrors.get("email"));
                    }
                    if (this.adminAddErrors.containsKey("password")) {
                        DialogUtil.showError(null, "Error Password: " + this.adminAddErrors.get("password"));
                    }
                    if (this.adminAddErrors.containsKey("tanggalLahir")) {
                        DialogUtil.showError(null, "Error Tanggal Lahir: " + this.adminAddErrors.get("tanggalLahir"));
                    }
                    if (this.adminAddErrors.containsKey("pekerjaan")) {
                        DialogUtil.showError(null, "Error Pekerjaan: " + this.adminAddErrors.get("pekerjaan"));
                    }
                    if (this.adminAddErrors.containsKey("bio")) {
                        DialogUtil.showError(null, "Error Bio: " + this.adminAddErrors.get("bio"));
                    }
                    if (this.adminAddErrors.containsKey("domisili")) {
                        DialogUtil.showError(null, "Error Domisili: " + this.adminAddErrors.get("domisili"));
                    }

                    return;
                } else {
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                    dummyData.size() + 1,
                    dummyData.size() + 1,
                    valuesNamaAdmin,
                    valuesEmail,
                    valuesPassword,
                    valuesTanggalLahir,
                    valuesPekerjaan,
                    valuesBio,
                    valuesDomisili,
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
        BaseFormDialog dialog = new AdminEditFormDialog();

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

            // Get Values from selected row for Update
            Object valuesIdUser = tableModel.getValueAt(selectedRow, 0);
            Object valuesIdAdmin = tableModel.getValueAt(selectedRow, 1);
            Object valuesEmail = tableModel.getValueAt(selectedRow, 3);
            Object valuesPassword = tableModel.getValueAt(selectedRow, 4);

            Map<String, String> values = dialog.getFormValues();

            String valuesNamaAdmin = values.get("Nama Admin");

            Date spinnerDate = (Date) dialog.getCustomFieldValue("Tanggal Lahir");
            String valuesTanggalLahir = spinnerDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
            String valuesPekerjaan = values.get("Pekerjaan");
            String valuesBio = values.get("Bio");
            String valuesDomisili = values.get("Domisili");

            // JAKARTA VALIDATION
            this.adminEditRequest.setNamaAdmin(valuesNamaAdmin);
            this.adminEditRequest.setTanggalLahir(valuesTanggalLahir);
            this.adminEditRequest.setPekerjaan(valuesPekerjaan);
            this.adminEditRequest.setBio(valuesBio);
            this.adminEditRequest.setDomisili(valuesDomisili);

            this.adminEditErrors = GlobalExceptionHandler.handleValidation(this.adminEditRequest);
                if (!this.adminEditErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.adminEditErrors.containsKey("namaAdmin")) {
                        DialogUtil.showError(null, "Error Nama Admin: " + this.adminEditErrors.get("namaAdmin"));
                    }
                    if (this.adminEditErrors.containsKey("tanggalLahir")) {
                        DialogUtil.showError(null, "Error Tanggal Lahir: " + this.adminEditErrors.get("tanggalLahir"));
                    }
                    if (this.adminEditErrors.containsKey("pekerjaan")) {
                        DialogUtil.showError(null, "Error Pekerjaan: " + this.adminEditErrors.get("pekerjaan"));
                    }
                    if (this.adminEditErrors.containsKey("bio")) {
                        DialogUtil.showError(null, "Error Bio: " + this.adminEditErrors.get("bio"));
                    }
                    if (this.adminEditErrors.containsKey("domisili")) {
                        DialogUtil.showError(null, "Error Domisili: " + this.adminEditErrors.get("domisili"));
                    }

                    return;
                } else {
                    // JIKA AMAN: Lanjutkan proses Register
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                valuesIdUser,
                valuesIdAdmin,
                valuesNamaAdmin,
                valuesEmail,
                valuesPassword,
                valuesTanggalLahir,
                valuesPekerjaan,
                valuesBio,
                valuesDomisili,
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