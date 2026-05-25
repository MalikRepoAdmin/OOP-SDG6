package views.sungai;

import views.base.BaseFormDialog;
import views.utils.DialogUtil;

import java.util.Map;

public class SungaiFormDialog extends BaseFormDialog {

    public SungaiFormDialog() {

        super(
                null,
                "Form Sungai",
                new String[] {
                        "Nama Sungai",
                        "Kategori",
                        "Status"
                }
        );

        initializeActions();
    }

    private void initializeActions() {

        setOnSave(() -> {

            Map<String, String> values =
                    getFormValues();

            if (values.get("Nama Sungai")
                    .isBlank()) {

                DialogUtil.showError(
                        this,
                        "Nama sungai wajib diisi"
                );

                return;
            }

            dispose();
        });
    }
}