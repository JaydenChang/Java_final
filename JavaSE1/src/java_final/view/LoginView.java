package java_final.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java_final.dao.*;
import java_final.base.*;
import java_final.util.*;

public class LoginView extends JFrame {
    // private static final long serialVersionUID =
    private JPanel panelCenter, panelSouth;
    private JTextField userName;
    private JPasswordField password;
    private JButton loginBtn, resetBtn;

    public LoginView() {
        init();
    }

    public void init() {
        this.setTitle("Login");

        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(3, 2));
        panelCenter.add(new JLabel(AppConst.loginUserName));
        userName = new JTextField();

        panelCenter.add(userName);
        panelCenter.add(new JLabel(AppConst.loginPassword));
        password = new JPasswordField();
        // enter key listener
        password.addKeyListener(new LoginListener());
        // password.setSize(120, 30);
        panelCenter.add(password);
        panelCenter.add(new JLabel("\n"));

        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 2));
        loginBtn = new JButton(AppConst.loginBtn);
        // loginBtn.setSize(100, 20);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
        panelSouth.add(loginBtn);
        resetBtn = new JButton(AppConst.resetBtn);
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName.setText("");
                password.setText("");
            }
        });
        resetBtn.setSize(100, 30);
        panelSouth.add(resetBtn);

        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(
                new ImageIcon(MainView.class.getResource("/java_final/source/image/Jayden.jpg")).getImage());
        this.setBounds(450, 250, 385, 140);
        this.setResizable(true);
        this.setVisible(true);
    }

    private class LoginListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                check();
            }
        }
    }

    private void check() {
        AdminDAO adminDao = (AdminDAO) BaseDAO.getAbilityDAO(DAO.AdminDAO);
        if (adminDao.queryForLogin(userName.getText(), String.valueOf(password.getPassword()))) {
            dispose();
            new MainView();
        } else {
            JOptionPane.showMessageDialog(null, "请检查账户和密码是否正确", "Warning", JOptionPane.WARNING_MESSAGE);
            userName.setText("");
            password.setText("");
            userName.requestFocus();
        }
    }
}
