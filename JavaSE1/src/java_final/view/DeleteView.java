package java_final.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java_final.base.*;
import java_final.dao.*;
import java_final.model.*;
import java_final.util.*;

public class DeleteView extends JFrame {
    // private static final long serialVersionUID =
    private JPanel panelCenter, panelSouth;
    private JButton deleteBtn, exitBtn;
    private JTextField name, stuNo;

    public DeleteView() {
        init();
    }

    private void init() {
        setTitle(AppConst.deleteViewTitle);
        // center panel
        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(3, 2));
        panelCenter.add(new JLabel(AppConst.studentName));
        name = new JTextField();
        panelCenter.add(name);
        panelCenter.add(new JLabel(AppConst.studentStuNo));
        stuNo = new JTextField();
        panelCenter.add(stuNo);
        panelCenter.add(new JLabel("\n"));

        // south panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 2));
        deleteBtn = new JButton(AppConst.deleteViewDeleteBtn);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    Student stu = new Student();
                    buildStudent(stu);
                    boolean isSuccess = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).delete(stu);
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
        panelSouth.add(deleteBtn);
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

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 250, 400, 130);
        setResizable(false);
        setVisible(true);
    }

    private boolean check() {
        boolean result = false;
        if ("".equals(name.getText()) || "".equals(stuNo.getText())) {
            return result;
        } else {
            result = true;
        }
        return result;
    }

    private void buildStudent(Student stu) {
        stu.setName(name.getText());
        stu.setStuNo(stuNo.getText());
    }

    private void setEmpty() {
        name.setText("");
        stuNo.setText("");
    }
}
