package views.sungai;

import java.util.Map;

import views.base.BaseFormDialog;
import views.utils.DialogUtil;

public class SungaiEditFormDialog extends BaseFormDialog {

	public SungaiEditFormDialog() {
		super (
			null,
			"Form Edit Sungai",
			new String[] {
				"Nama Sungai",
            	"Kategori",
            	"Status",
			}
		);

		initializeActions();
	}

	private void initializeActions() {

        setOnSave(() -> {

            Map<String, String> values =
                    getFormValues();

            dispose();
        });
    }
}