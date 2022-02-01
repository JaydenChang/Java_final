package java_final.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

import org.apache.poi.hssf.usermodel.*;
// import org.apache.poi.hssf.util.*;
// import org.apache.poi.ss.usermodel.HorizontalAlignment;
// import org.apache.poi.ss.util.*;

import java_final.dao.*;
// import java_final.model.*;
import java_final.util.*;
import java_final.base.*;

public class InfoView extends JFrame {
    private JPanel panelCenter, panelSouth;
    private JButton exitBtn, exportBtn;
    private JLabel name, stuNo, department, totalMark, linuxPoint, cppPoint, javaPoint, GPA;

    public InfoView(String name) {
        init(name);
    }

    private void init(String name) {
        setTitle(name + "的" + AppConst.infoViewTitle);
        String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).queryByName(name);
        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(9, 2));
        panelCenter.add(new JLabel(AppConst.studentName + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][1], JLabel.CENTER));
        panelCenter.add(new JLabel(AppConst.studentStuNo + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][2], JLabel.CENTER));
        panelCenter.add(new JLabel(AppConst.studentDepartment + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][3], JLabel.CENTER));
        panelCenter.add(new JLabel(AppConst.studentTotalMark + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][4], JLabel.CENTER));
        panelCenter.add(new JLabel(AppConst.studentLinuxPoint + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][5], JLabel.CENTER));
        panelCenter.add(new JLabel(AppConst.studentCppPoint + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][6], JLabel.CENTER));
        panelCenter.add(new JLabel(AppConst.studentJavaPoint + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][7], JLabel.CENTER));
        panelCenter.add(new JLabel(AppConst.studentGPA + ": ", JLabel.CENTER));
        panelCenter.add(new JLabel(result[0][8], JLabel.CENTER));
        panelCenter.add(new JLabel("\n"));

        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 2));
        exportBtn = new JButton(AppConst.infoViewExportBtn);
        exportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    export(name);
                    JOptionPane.showMessageDialog(null, "导出成功");
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
        });
        panelSouth.add(exportBtn);

        exitBtn = new JButton(AppConst.ExitBtn);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelSouth.add(exitBtn);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        setIconImage(
                new ImageIcon(MainView.class.getResource("/java_final/source/image/Jayden.jpg")).getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 200, 200, 270);
        setResizable(false);
        setVisible(true);
    }

    private void export(String name) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row0 = sheet.createRow(0);
        String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).queryByName(name);
        row0.createCell(0).setCellValue(AppConst.studentName);
        row0.createCell(1).setCellValue(result[0][1]);
        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(AppConst.studentStuNo);
        row1.createCell(1).setCellValue(result[0][2]);
        HSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue(AppConst.studentDepartment);
        row2.createCell(1).setCellValue(result[0][3]);
        HSSFRow row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue(AppConst.studentTotalMark);
        row3.createCell(1).setCellValue(result[0][4]);
        HSSFRow row4 = sheet.createRow(4);
        row4.createCell(0).setCellValue(AppConst.studentCppPoint);
        row4.createCell(1).setCellValue(result[0][5]);
        HSSFRow row5 = sheet.createRow(5);
        row5.createCell(0).setCellValue(AppConst.studentLinuxPoint);
        row5.createCell(1).setCellValue(result[0][6]);
        HSSFRow row6 = sheet.createRow(6);
        row6.createCell(0).setCellValue(AppConst.studentJavaPoint);
        row6.createCell(1).setCellValue(result[0][7]);
        HSSFRow row7 = sheet.createRow(7);
        row7.createCell(0).setCellValue(AppConst.studentGPA);
        row7.createCell(1).setCellValue(result[0][8]);

        wb.setSheetName(0, result[0][1] + "的信息表");

        FileSystemView home = FileSystemView.getFileSystemView();
        File homePath = home.getHomeDirectory();
        FileOutputStream out = new FileOutputStream(homePath + "/" + result[0][1] + "的信息表.xls");
        wb.write(out);
        out.close();
        wb.close();
    }
}
