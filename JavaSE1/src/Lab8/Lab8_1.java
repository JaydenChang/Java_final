package Lab8;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Lab8_1 extends JFrame {
    public static void main(String[] args) {
        new Lab8_1();
    }

    Container con = getContentPane();

    public Lab8_1() {
        setTitle("sign up");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);

        JLabel label1 = new JLabel("name");
        label1.setBounds(10, 10, 60, 20);

        JTextField name = new JTextField("", 20);
        name.setBounds(80, 10, 120, 20);

        JLabel label2 = new JLabel("password");
        label2.setBounds(10, 40, 60, 20);

        JPasswordField passwd = new JPasswordField();
        passwd.setBounds(80, 40, 120, 20);

        JLabel label3 = new JLabel("gender");
        label3.setBounds(10, 70, 40, 20);

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
        checkBox2.setBounds(150, 100, 80, 20);
        JCheckBox checkBox3 = new JCheckBox("photograph");
        checkBox3.setBounds(210, 100, 140, 20);

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
        // add(intro);
        setVisible(true);

    }
}
