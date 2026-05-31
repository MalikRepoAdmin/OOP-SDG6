package views.user;

import views.base.BaseCrudPanel;
import views.base.BaseFormDialog;
import views.base.BaseTableModel;
import views.utils.DialogUtil;
import views.validator.GlobalExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class UserPanel extends BaseCrudPanel {

    private final BaseTableModel tableModel;
    private final List<Object[]> dummyData;

    private UserAddRequest userAddRequest = new UserAddRequest();
    private Map<String, String> userAddErrors;

    private UserEditRequest userEditRequest = new UserEditRequest();
    private Map<String, String> userEditErrors;


    public UserPanel() {

        dummyData = new ArrayList<>();

        tableModel = new UserTableModel();

        setTableModel(tableModel);

        initializeDummyData();

        initializeActions();
    }


    private void initializeDummyData() {

        dummyData.add(new Object[] {
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

        BaseFormDialog dialog = new UserAddFormDialog();

        dialog.setOnSave(() -> {

            Map<String, String> values = dialog.getFormValues();

            // Add Date input into dialog
            SpinnerDateModel dateModel = new SpinnerDateModel();
            JSpinner dateSpinner = new JSpinner(dateModel);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
            dateSpinner.setEditor(dateEditor);

            dialog.add(new JLabel("Tanggal Lahir:"));
            dialog.add(dateSpinner);


            String valuesNamaUser = values.get("Nama User");
            String valuesEmail = values.get("Email");
            String valuesPassword = values.get("Password");
            String valuesTanggalLahir = dateSpinner.getValue().toString();
            String valuesPekerjaan = values.get("Pekerjaan");
            String valuesBio = values.get("Bio");
            String valuesDomisili = values.get("Domisili");

            // JAKARTA VALIDATION
            this.userAddRequest.setNamaUser(valuesNamaUser);
            this.userAddRequest.setEmail(valuesEmail);
            this.userAddRequest.setPassword(valuesPassword);
            this.userAddRequest.setTanggalLahir(valuesTanggalLahir);
            this.userAddRequest.setPekerjaan(valuesPekerjaan);
            this.userAddRequest.setBio(valuesBio);
            this.userAddRequest.setDomisili(valuesDomisili);

            this.userAddErrors = GlobalExceptionHandler.handleValidation(this.userAddRequest);
                if (!this.userAddErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.userAddErrors.containsKey("namaUser")) {
                        DialogUtil.showError(null, "Error Nama User: " + this.userAddErrors.get("namaUser"));
                    }
                    if (this.userAddErrors.containsKey("email")) {
                        DialogUtil.showError(null, "Error Email: " + this.userAddErrors.get("email"));
                    }
                    if (this.userAddErrors.containsKey("password")) {
                        DialogUtil.showError(null, "Error Password: " + this.userAddErrors.get("password"));
                    }
                    if (this.userAddErrors.containsKey("tanggalLahir")) {
                        DialogUtil.showError(null, "Error Tanggal Lahir: " + this.userAddErrors.get("tanggalLahir"));
                    }
                    if (this.userAddErrors.containsKey("pekerjaan")) {
                        DialogUtil.showError(null, "Error Pekerjaan: " + this.userAddErrors.get("pekerjaan"));
                    }
                    if (this.userAddErrors.containsKey("bio")) {
                        DialogUtil.showError(null, "Error Bio: " + this.userAddErrors.get("bio"));
                    }
                    if (this.userAddErrors.containsKey("domisili")) {
                        DialogUtil.showError(null, "Error Domisili: " + this.userAddErrors.get("domisili"));
                    }

                    return;
                } else {
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                    dummyData.size() + 1,
                    valuesNamaUser,
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
        BaseFormDialog dialog = new UserEditFormDialog();

        // Add Date input into dialog
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
        dateSpinner.setEditor(dateEditor);

        dialog.add(new JLabel("Tanggal Lahir:"));
        dialog.add(dateSpinner);


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
            Object valuesEmail = tableModel.getValueAt(selectedRow, 2);
            Object valuesPassword = tableModel.getValueAt(selectedRow, 3);

            Map<String, String> values = dialog.getFormValues();

            String valuesNamaUser = values.get("Nama User");
            String valuesTanggalLahir = values.get("Tanggal Lahir");
            String valuesPekerjaan = values.get("Pekerjaan");
            String valuesBio = values.get("Bio");
            String valuesDomisili = values.get("Domisili");

            // JAKARTA VALIDATION
            this.userEditRequest.setNamaUser(valuesNamaUser);
            this.userEditRequest.setTanggalLahir(valuesTanggalLahir);
            this.userEditRequest.setPekerjaan(valuesPekerjaan);
            this.userEditRequest.setBio(valuesBio);
            this.userEditRequest.setDomisili(valuesDomisili);

            this.userEditErrors = GlobalExceptionHandler.handleValidation(this.userEditRequest);
                if (!this.userEditErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.userAddErrors.containsKey("namaUser")) {
                        DialogUtil.showError(null, "Error Nama User: " + this.userAddErrors.get("namaUser"));
                    }
                    if (this.userAddErrors.containsKey("tanggalLahir")) {
                        DialogUtil.showError(null, "Error Tanggal Lahir: " + this.userAddErrors.get("tanggalLahir"));
                    }
                    if (this.userAddErrors.containsKey("pekerjaan")) {
                        DialogUtil.showError(null, "Error Pekerjaan: " + this.userAddErrors.get("pekerjaan"));
                    }
                    if (this.userAddErrors.containsKey("bio")) {
                        DialogUtil.showError(null, "Error Bio: " + this.userAddErrors.get("bio"));
                    }
                    if (this.userAddErrors.containsKey("domisili")) {
                        DialogUtil.showError(null, "Error Domisili: " + this.userAddErrors.get("domisili"));
                    }

                    return;
                } else {
                    // JIKA AMAN: Lanjutkan proses Register
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke database...");
                }

            Object[] row = new Object[] {
                valuesIdUser,
                valuesNamaUser,
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