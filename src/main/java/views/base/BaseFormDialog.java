package views.base;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Dynamic form dialog.
 *
 * Fields are generated dynamically.
 */
public class BaseFormDialog extends JDialog {

    private final Map<String, JTextField> fieldMap;

    private final Map<String, JComponent> customFieldMap;

    private JPanel formPanel;

    private Runnable onSave;

    public BaseFormDialog(
            Frame owner,
            String title,
            String[] fields
    ) {

        super(owner, title, true);

        fieldMap = new LinkedHashMap<>();
        customFieldMap = new LinkedHashMap<>();

        initialize(fields);
    }

    private void initialize(String[] fields) {

        setLayout(new BorderLayout(10, 10));

        formPanel = new JPanel(new GridLayout(fields.length, 2, 10, 10));

        for (String field : fields) {

            JLabel label = new JLabel(field);

            JTextField textField = new JTextField();

            fieldMap.put(field, textField);

            formPanel.add(label);
            formPanel.add(textField);
        }

        JButton saveButton = new JButton("Simpan");
        JButton cancelButton = new JButton("Batal");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> {
            if (onSave != null) {
                onSave.run();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
    }

    public Map<String, String> getFormValues() {

        Map<String, String> values = new LinkedHashMap<>();

        fieldMap.forEach((key, value) -> {
            values.put(key, value.getText());
        });

        return values;
    }

    public void setFieldValue(String fieldName, String value) {

        JTextField field = fieldMap.get(fieldName);

        if (field != null) {
            field.setText(value);
        }
    }

    public JSpinner createDateField() {

        // Add Date input into dialog
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
        dateSpinner.setEditor(dateEditor);

        return dateSpinner;
    }

    public void replaceField(String fieldName, JComponent replacementComponent) {
        
        JTextField oldField = fieldMap.get(fieldName);

        if (oldField == null) {
            return;
        }

        Container parent = oldField.getParent();
        Component[] components = parent.getComponents();

        for (int i = 0; i < components.length; i++) {
            
            if (components[i] == oldField) {
                
                parent.remove(oldField);

                parent.add(replacementComponent, i);

                break;
            }
        }

        parent.revalidate();
        parent.repaint();
        pack();

        customFieldMap.put(fieldName, replacementComponent);
    }

    public Object getCustomFieldValue(String fieldName) {

        JComponent component = customFieldMap.get(fieldName);

        if (component == null) {
            return null;
        }

        if (component instanceof JSpinner spinner) {
            return spinner.getValue();
        }

        if (component instanceof JComboBox<?> comboBox) {
            return comboBox.getSelectedItem();
        }

        if (component instanceof JCheckBox checkBox) {
            return checkBox.isSelected();
        }

        return null;
    }

    public void setOnSave(Runnable onSave) {
        this.onSave = onSave;
    }
}