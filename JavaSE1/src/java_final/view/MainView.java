package java_final.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.filechooser.*;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;

import java_final.dao.*;
// import java_final.App;
import java_final.base.*;
import java_final.util.*;

public class MainView extends JFrame {
    // private static final long serialVersionUID =
    private final int maxPageNum = 99;

    private JPanel panelNorth, panelSouth, panelCenter;
    private JButton firstBtn, lastBtn, nextBtn, preBtn, addBtn, deleteBtn, updateBtn, findBtn, infoBtn;
    private JLabel currPageNumLabel;
    private JTextField condition;
    private JScrollPane scrollPane;
    public static JTable table;
    private JMenuBar menuBar;

    // private DefaultTableModel tableModel;
    DefaultTableModel tableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public static String[] column = { "id", AppConst.studentName, AppConst.studentStuNo, AppConst.studentDepartment,
            AppConst.studentTotalMark, AppConst.studentLinuxPoint, AppConst.studentCppPoint, AppConst.studentJavaPoint,
            AppConst.studentGPA };
    public static int currPageNum = 1;

    public MainView() {
        init();
    }

    public void init() {
        setTitle(AppConst.mainViewTitle);

        menuBar = new JMenuBar();
        // tempMenuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu1 = new JMenu("菜单");
        JMenu menu2 = new JMenu("凑数的菜单");
        JMenuItem exportMenu = new JMenuItem("导出当前表格");
        JMenuItem exitMenu = new JMenuItem("退出");

        JMenuItem testItem1 = new JMenuItem("凑数项1");
        JMenuItem testItem2 = new JMenuItem("凑数项2");

        menuBar.add(menu1);
        menuBar.add(menu2);

        menu1.add(exportMenu);
        menu1.add(exitMenu);

        menu2.add(testItem1);
        menu2.add(testItem2);

        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        exportMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                export();
                JOptionPane.showMessageDialog(null, "导出完成");
            }
        });

        // north panel
        panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(1, 6));
        // panelNorth.add(menuBar);
        // panelNorth.add(tempMenuBar);
        // panelNorth.add(new JLabel());
        // panelNorth.add(new JLabel());
        // panelNorth.add(new JLabel());
        // panelNorth.add(new JLabel());
        // panelNorth.add(new JLabel());
        condition = new JTextField(AppConst.paramFindConition);
        condition.addKeyListener(new FindListener());
        panelNorth.add(condition);
        // queryByName

        findBtn = new JButton(AppConst.paramFind);
        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find();
            }
        });
        findBtn.addKeyListener(new FindListener());
        panelNorth.add(findBtn);
        // add
        addBtn = new JButton(AppConst.paramAdd);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddView();
            }
        });
        panelNorth.add(addBtn);
        // delete
        deleteBtn = new JButton(AppConst.paramDelete);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new DeleteView();
                // 手动输入学号姓名搜索再删除太繁琐了
                int index = table.getSelectedRow();
                if (index < 0) {
                    JOptionPane.showMessageDialog(null, "请选择一行");
                } else {
                    int judge = JOptionPane.showConfirmDialog(null, "你真的要删除吗?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (judge == 0) {
                        new DeleteModel(table.getValueAt(index, 1).toString());
                    }
                }
            }
        });
        panelNorth.add(deleteBtn);
        // update
        updateBtn = new JButton(AppConst.paramUpdate);
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                if (index < 0) {
                    JOptionPane.showMessageDialog(null, "请选择一行");
                } else {
                    new UpdateView(table.getValueAt(index, 1).toString());
                }
            }
        });
        panelNorth.add(updateBtn);
        // detail info
        infoBtn = new JButton(AppConst.MainViewInfoBtn);
        infoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                if (index < 0) {
                    JOptionPane.showMessageDialog(null, "请选择一行");
                } else {
                    new InfoView(table.getValueAt(index, 1).toString());
                }
            }
        });
        panelNorth.add(infoBtn);
        // panelCenter
        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 1));

        // initJTable panel
        String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).list(currPageNum);
        tableModel = new DefaultTableModel(result, column);
        table = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus,
                    int row, int column) {
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        cr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, cr);
        initJTable(table, result);

        scrollPane = new JScrollPane(table);
        panelCenter.add(scrollPane);

        // south panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 5));

        firstBtn = new JButton(AppConst.mainViewFirst);
        firstBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPageNum = 1;
                String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).list(currPageNum);
                initJTable(table, result);
                currPageNumLabel.setText(currPageNum + AppConst.mainViewPageNum);
            }
        });
        preBtn = new JButton(AppConst.mainViewPre);
        preBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPageNum--;
                if (currPageNum <= 0) {
                    currPageNum = 1;
                }
                String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).list(currPageNum);
                initJTable(table, result);
                currPageNumLabel.setText(currPageNum + AppConst.mainViewPageNum);
            }
        });
        nextBtn = new JButton(AppConst.mainViewNext);
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPageNum++;
                if (currPageNum > maxPageNum) {
                    currPageNum = maxPageNum;
                }
                String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).list(currPageNum);
                initJTable(table, result);
                currPageNumLabel.setText(currPageNum + AppConst.mainViewPageNum);
            }
        });
        lastBtn = new JButton(AppConst.mainViewLast);
        lastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPageNum = maxPageNum;
                String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).list(currPageNum);
                initJTable(table, result);
                currPageNumLabel.setText(currPageNum + AppConst.mainViewPageNum);
            }
        });

        currPageNumLabel = new JLabel(currPageNum + AppConst.mainViewPageNum);
        currPageNumLabel.setHorizontalAlignment(JLabel.CENTER);

        panelSouth.add(firstBtn);
        panelSouth.add(preBtn);
        panelSouth.add(currPageNumLabel);
        panelSouth.add(nextBtn);
        panelSouth.add(lastBtn);

        // this.add(panelMenu, BorderLayout.NORTH);
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        setIconImage(
                new ImageIcon(MainView.class.getResource("/java_final/source/image/Jayden.jpg")).getImage());
        setBounds(400, 200, 615, 335);

        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void initJTable(JTable table, String[][] result) {
        ((DefaultTableModel) table.getModel()).setDataVector(result, column);
        table.setRowHeight(20);
        TableColumn firstColumn = table.getColumnModel().getColumn(0);
        firstColumn.setPreferredWidth(30);
        firstColumn.setMaxWidth(30);
        firstColumn.setMinWidth(30);
        TableColumn secondColumn = table.getColumnModel().getColumn(1);
        secondColumn.setPreferredWidth(90);
        secondColumn.setMaxWidth(90);
        secondColumn.setMinWidth(90);
        TableColumn thirdColumn = table.getColumnModel().getColumn(2);
        thirdColumn.setPreferredWidth(90);
        thirdColumn.setMaxWidth(90);
        thirdColumn.setMinWidth(90);
        TableColumn fourthColumn = table.getColumnModel().getColumn(3);
        fourthColumn.setPreferredWidth(90);
        fourthColumn.setMaxWidth(90);
        fourthColumn.setMinWidth(90);
        TableColumn fifthColumn = table.getColumnModel().getColumn(4);
        fifthColumn.setPreferredWidth(60);
        fifthColumn.setMaxWidth(60);
        fifthColumn.setMinWidth(60);
        TableColumn sixthColumn = table.getColumnModel().getColumn(5);
        sixthColumn.setPreferredWidth(60);
        sixthColumn.setMaxWidth(60);
        sixthColumn.setMinWidth(60);
        TableColumn seventhColumn = table.getColumnModel().getColumn(6);
        seventhColumn.setPreferredWidth(60);
        seventhColumn.setMaxWidth(60);
        seventhColumn.setMinWidth(60);
        TableColumn eighthColumn = table.getColumnModel().getColumn(7);
        eighthColumn.setPreferredWidth(60);
        eighthColumn.setMaxWidth(60);
        eighthColumn.setMinWidth(60);
        TableColumn ninthColumn = table.getColumnModel().getColumn(8);
        ninthColumn.setPreferredWidth(60);
        ninthColumn.setMaxWidth(60);
        ninthColumn.setMinWidth(60);
    }

    private class FindListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                find();
            }
        }
    }

    private void find() {
        currPageNum = 0;
        String param = condition.getText();
        if ("".equals(param) || param == null) {
            initJTable(MainView.table, null);
            currPageNumLabel.setText(AppConst.mainViewFindLabel);
            return;
        }
        String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).queryByName(param);
        condition.setText("");
        initJTable(MainView.table, result);
        currPageNumLabel.setText(AppConst.mainViewFindLabel);
    }

    private void export() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet hs = wb.createSheet();
        TableModel tm = table.getModel();
        int row = tm.getRowCount();
        int column = tm.getColumnCount();
        // System.out.println(row + " " + column);

        for (int i = 0; i <= row; i++) {
            HSSFRow hr = hs.createRow(i);
            for (int j = 0; j < column; j++) {
                if (i == 0) {
                    String value = tm.getColumnName(j);
                    HSSFRichTextString srts = new HSSFRichTextString(value);
                    HSSFCell hc = hr.createCell(j);

                    hc.setCellValue(srts);
                } else {
                    if (tm.getValueAt(i - 1, j) != null) {
                        String value = tm.getValueAt(i - 1, j).toString();
                        HSSFRichTextString srts = new HSSFRichTextString(value);
                        HSSFCell hc = hr.createCell((short) j);
                        if (value.equals("") || value == null) {
                            hc.setCellValue(new HSSFRichTextString(""));
                        } else {
                            hc.setCellValue(srts);
                        }
                    }
                }
            }
        }
        try {
            FileSystemView home = FileSystemView.getFileSystemView();
            File homePath = home.getHomeDirectory();
            FileOutputStream out = new FileOutputStream(homePath + "/学生信息表.xls");
            wb.write(out);
            wb.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
