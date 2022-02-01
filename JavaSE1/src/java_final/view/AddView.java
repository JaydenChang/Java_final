package java_final.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java_final.dao.*;
import java_final.model.*;
import java_final.util.AppConst;
import java_final.base.*;
import java_final.util.*;

public class AddView extends JFrame {
    // private static final long serialVersionUID =
    private JPanel panelCenter, panelSouth;
    private JButton addBtn, exitBtn;
    private JTextField name, stuNo, department, totalMark, linuxPoint, cppPoint, javaPoint, GPA;

    public AddView() {
        init();
    }

    public void init() {
        setTitle(AppConst.addViewTitle);

        // center panel
        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(10, 2));
        panelCenter.add(new JLabel(AppConst.studentName));
        name = new JTextField();
        panelCenter.add(name);
        panelCenter.add(new JLabel(AppConst.studentStuNo));
        stuNo = new JTextField();
        panelCenter.add(stuNo);
        panelCenter.add(new JLabel(AppConst.studentDepartment));
        department = new JTextField();
        panelCenter.add(department);
        panelCenter.add(new JLabel(AppConst.studentTotalMark));
        totalMark = new JTextField();
        panelCenter.add(totalMark);
        panelCenter.add(new JLabel(AppConst.studentLinuxPoint));
        linuxPoint = new JTextField();
        panelCenter.add(linuxPoint);
        panelCenter.add(new JLabel(AppConst.studentCppPoint));
        cppPoint = new JTextField();
        panelCenter.add(cppPoint);
        panelCenter.add(new JLabel(AppConst.studentLinuxPoint));
        javaPoint = new JTextField();
        panelCenter.add(javaPoint);
        panelCenter.add(new JLabel(AppConst.studentGPA));
        GPA = new JTextField();
        panelCenter.add(GPA);
        panelCenter.add(new JLabel("\n"));

        // south panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 2));
        addBtn = new JButton(AppConst.addViewAddBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    Student stu = new Student();
                    buildStudent(stu);
                    boolean isSuccess = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).add(stu);
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
        panelSouth.add(addBtn);
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
        setBounds(470, 200, 350, 310);
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
        // stu.setGPA(stu.calcGPA());
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
