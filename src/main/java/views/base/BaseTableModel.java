package views.base;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic dynamic table model.
 *
 * Uses Object[] rows so entity structure can change easily.
 */
public class BaseTableModel extends AbstractTableModel {

    private final String[] columns;

    private final List<Object[]> rows;

    public BaseTableModel(String[] columns) {

        this.columns = columns;

        this.rows = new ArrayList<>();
    }

    public void setRows(List<Object[]> data) {

        rows.clear();
        rows.addAll(data);

        fireTableDataChanged();
    }

    public void addRow(Object[] row) {

        rows.add(row);

        fireTableRowsInserted(rows.size() - 1, rows.size() - 1);
    }

    public Object[] getRow(int index) {
        return rows.get(index);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }
}