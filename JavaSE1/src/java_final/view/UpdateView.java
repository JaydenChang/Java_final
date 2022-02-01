package java_final.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java_final.base.BaseDAO;
import java_final.model.Student;
import java_final.util.AppConst;
import java_final.dao.*;
import java_final.util.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class UpdateView extends JFrame {
    // private static final long serialVersionUID =
    private JPanel panelSouth, panelCenter;
    private JButton updateBtn, exitBtn;
    private JTextField name, stuNo, department, totalMark, linuxPoint, cppPoint, javaPoint, GPA;

    public UpdateView(String query) {
        init(query);
    }

    private void init(String query) {
        setTitle(AppConst.updateViewTitle);
        String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).queryByName(query);

        // center panel
        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(10, 2));
        panelCenter.add(new JLabel(AppConst.studentName));
        name = new JTextField(result[0][1]);
        panelCenter.add(name);
        panelCenter.add(new JLabel(AppConst.studentStuNo));
        stuNo = new JTextField(result[0][2]);
        panelCenter.add(stuNo);
        panelCenter.add(new JLabel(AppConst.studentDepartment));
        department = new JTextField(result[0][3]);
        panelCenter.add(department);
        panelCenter.add(new JLabel(AppConst.studentTotalMark));
        totalMark = new JTextField(result[0][4]);
        panelCenter.add(totalMark);
        panelCenter.add(new JLabel(AppConst.studentLinuxPoint));
        linuxPoint = new JTextField(result[0][5]);
        panelCenter.add(linuxPoint);
        panelCenter.add(new JLabel(AppConst.studentCppPoint));
        cppPoint = new JTextField(result[0][6]);
        panelCenter.add(cppPoint);
        panelCenter.add(new JLabel(AppConst.studentJavaPoint));
        javaPoint = new JTextField(result[0][7]);
        panelCenter.add(javaPoint);
        panelCenter.add(new JLabel(AppConst.studentGPA));
        GPA = new JTextField(result[0][8]);
        panelCenter.add(GPA);
        panelCenter.add(new JLabel("\n"));

        // south panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 2));
        updateBtn = new JButton(AppConst.updateViewUpdateBtn);
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    Student stu = new Student();
                    buildStudent(stu);
                    boolean isSuccess = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).update(stu);
                    if (isSuccess) {
                        setEmpty();
                        if (MainView.currPageNum < 0 || MainView.currPageNum > 99) {
                            MainView.currPageNum = 1;
                        }
                        String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO))
                                .list(MainView.currPageNum);
                        MainView.initJTable(MainView.table, result);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请检查输入的数据是否完整", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panelSouth.add(updateBtn);
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
        setBounds(470, 200, 400, 270);
        setResizable(false);
        setVisible(true);

    }

    private boolean check() {
        boolean result = false;
        if ("".equals(name.getText()) || "".equals(stuNo.getText()) || "".equals(department.getText())
                || "".equals(totalMark.getText()) || "".equals(linuxPoint.getText()) || "".equals(cppPoint.getText())
                || "".equals(javaPoint.getText()) || "".equals(GPA.getText())) {
            return result;
        } else {
            result = true;
        }
        return result;
    }

    private void buildStudent(Student stu) {
        stu.setName(name.getText());
        stu.setStuNo(stuNo.getText());
        stu.setDepartment(department.getText());
        stu.setTotalMark(totalMark.getText());
        stu.setLinuxPoint(linuxPoint.getText());
        stu.setCppPoint(cppPoint.getText());
        stu.setJavaPoint(javaPoint.getText());
        stu.setGPA(GPA.getText());
    }

    private void setEmpty() {
        name.setText("");
        stuNo.setText("");
        department.setText("");
        totalMark.setText("");
        linuxPoint.setText("");
        cppPoint.setText("");
        javaPoint.setText("");
        GPA.setText("");
    }
}

// class ExcelUtil {
// public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title,
// String[][] values, HSSFWorkbook wb) {
// if (wb == null) {
// wb = new HSSFWorkbook();
// }
// HSSFSheet sheet = wb.createSheet(sheetName);

// HSSFRow row = sheet.createRow(0);

// HSSFCellStyle style = wb.createCellStyle();
// style.setAlignment(HorizontalAlignment.CENTER);

// HSSFCell cell = null;

// for (int i = 0; i < title.length; i++) {
// cell = row.createCell(i);
// cell.setCellValue(title[i]);
// cell.setCellStyle(style);
// }

// for (int i = 0; i < values.length; i++) {
// row = sheet.createRow(i + 1);
// for (int j = 0; j < values.length; j++) {
// row.createCell(j).setCellValue(values[i][j]);
// }
// }
// return wb;
// }
// }
