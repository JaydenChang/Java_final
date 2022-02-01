package Lab8;

// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Lab8_3 extends JFrame {
    public static void main(String[] args) {
        new Lab8_3();
    }

    public Lab8_3() {
        setTitle("sign up");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);

        JLabel label1 = new JLabel("name");
        label1.setBounds(10, 10, 60, 20);

        JTextField name = new JTextField("", 20);
        name.setBounds(80, 10, 120, 20);

        JLabel label2 = new JLabel("password");
        label2.setBounds(10, 40, 60, 20);

        JPasswordField passwd = new JPasswordField();
        passwd.setBounds(80, 40, 120, 20);

        JLabel label3 = new JLabel("gender");
        label3.setBounds(10, 70, 60, 20);

        JRadioButton btn1 = new JRadioButton("male");
        JRadioButton btn2 = new JRadioButton("female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(btn1);
        genderGroup.add(btn2);
        btn1.setBounds(80, 70, 60, 20);
        btn2.setBounds(150, 70, 90, 20);

        JLabel label4 = new JLabel("hobby");
        label4.setBounds(10, 100, 40, 20);

        JCheckBox checkBox1 = new JCheckBox("sport");
        checkBox1.setBounds(80, 100, 70, 20);
        JCheckBox checkBox2 = new JCheckBox("music");
        checkBox2.setBounds(150, 100, 70, 20);
        JCheckBox checkBox3 = new JCheckBox("photograph");
        checkBox3.setBounds(220, 100, 140, 20);

        JLabel label5 = new JLabel("type");
        label5.setBounds(10, 130, 40, 20);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("--please choose--");
        comboBox.addItem("本科");
        comboBox.addItem("研究生");
        comboBox.addItem("专科");
        comboBox.setBounds(80, 130, 150, 20);

        JLabel label6 = new JLabel("campus");
        label6.setBounds(10, 160, 60, 20);

        Vector<String> vec = new Vector<String>();
        vec.add("石牌");
        vec.add("大学城");
        vec.add("南海");
        JList<String> campus = new JList<String>(vec);
        campus.setBounds(80, 160, 200, 80);

        JLabel label7 = new JLabel("self-intro");
        label7.setBounds(10, 250, 80, 20);

        JTextArea intro = new JTextArea(100, 80);
        JScrollPane scrollPane = new JScrollPane(intro);
        scrollPane.setBounds(80, 250, 200, 100);

        JButton sub = new JButton("submit");
        sub.setBounds(10, 400, 80, 40);

        JLabel introducion = new JLabel();
        introducion.setBounds(10, 500, 400, 200);

        String strType = comboBox.getEditor().getItem().toString();
        String strCampus = (String) campus.getSelectedValue();

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strName = name.getText();
                String strGender = "";
                String strHobby = "";
                if (btn1.isSelected()) {
                    strGender = "Male";
                } else if (btn2.isSelected()) {
                    strGender = "Female";
                }

                if (checkBox1.isSelected()) {
                    strHobby += "sport";
                } else if (checkBox2.isSelected()) {
                    strHobby += "music";
                } else if (checkBox3.isSelected()) {
                    strHobby += "photograph";
                }

                String strIntro = intro.getText();

                introducion.setText(strName + ", gender: " + strGender + ", hobby: " + strHobby + ", type: " + strType
                        + ", campus: " + strCampus + ", self-intro: " + strIntro);

            }
        });

        add(label1);
        add(name);
        add(label2);
        add(passwd);
        add(label3);
        add(btn1);
        add(btn2);
        add(label4);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(label5);
        add(comboBox);
        add(label6);
        add(campus);
        add(label7);
        add(scrollPane);
        add(sub);
        add(introducion);
        setVisible(true);

    }
}
