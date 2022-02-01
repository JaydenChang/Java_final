package java_final;

import java_final.util.*;
import java_final.view.*;

public class App {
    public static void initDB() {
        DBUtil dbUtil = DBUtil.getDBUtil();

        if (dbUtil.execute("select 1 from admin")) {
            return;
        }

        // admin
        dbUtil.execute("create table if not exists admin(id int primary key," +
                "name varchar(32)," +
                "password varchar(32))");
        dbUtil.execute("insert into admin(id, name, password) values(1,'root','admin')");

        // student
        dbUtil.execute("create table if not exists student(id int primary)" +
                "name varchar(32)" +
                "stuNo varchar(32)" +
                "department varchar(32)" +
                "totalMark varchar(32)" +
                "linuxPoint varchar(32)" +
                "cppPoint varchar(32)" +
                "javaPoint varchar(32)" +
                "GPA varchar(32))");
    }

    public static void main(String[] args) {
        initDB();
        new LoginView();
        // new MainView();
        // new AddView();
        DBUtil.getDBUtil().close();
    }
}
