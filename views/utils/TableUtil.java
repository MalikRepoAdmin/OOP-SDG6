package views.utils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public final class TableUtil {

    private TableUtil() {
    }

    public static void applyModernStyle(JTable table) {

        table.setRowHeight(30);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTableHeader header = table.getTableHeader();

        header.setFont(new Font("SansSerif", Font.BOLD, 14));
    }
}