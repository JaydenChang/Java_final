package java_final.view;

import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

import java_final.dao.*;
import java_final.base.*;
import java_final.model.*;

import org.apache.poi.hssf.usermodel.*;

public class ExcelExporter {
    public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < model.getColumnCount(); i++) {
            bWriter.write(model.getColumnName(i));
            bWriter.write("\t");
        }
        bWriter.newLine();
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                bWriter.write(model.getValueAt(i, j).toString());
                bWriter.write("\t");
            }
            bWriter.newLine();
        }
        bWriter.close();
    }
}
