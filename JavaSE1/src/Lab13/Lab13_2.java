package Lab13;

import java.sql.*;

public class Lab13_2 {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("load mysql successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql:" +
                    "//localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT",
                    "root", "admin");
            System.out.println("connect mysql successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Lab13_2 ll = new Lab13_2();
        con = ll.getConnection();
        try {
            sql = con.prepareStatement("select * from studb");
            res = sql.executeQuery();
            System.out.println("before add,edit,delete");
            while (res.next()) {
                String id = res.getString(1);
                String name = res.getString(2);
                String sex = res.getString(3);
                String grade = res.getString(4);
                String term = res.getString(5);
                String math = res.getString(6);
                String cpp = res.getString(7);
                String js = res.getString(8);
                System.out.print("id: " + id);
                System.out.print(" name: " + name);
                System.out.print(" sex: " + sex);
                System.out.print(" grade: " + grade);
                System.out.print(" term: " + term);
                System.out.print(" math: " + math);
                System.out.print(" cpp: " + cpp);
                System.out.println(" js: " + js);
            }
            // sql = con.prepareStatement("insert into studb" + " values(?,?,?,?,?,?,?,?)");
            // sql.setInt(1, 7);
            // sql.setString(2, "bb");
            // sql.setString(3, "temp");
            // sql.setInt(4, 18);
            // sql.setInt(5, 2);
            // sql.setInt(6, 70);
            // sql.setInt(7, 80);
            // sql.setInt(8, 90);
            // sql.executeUpdate();
            sql = con.prepareStatement("update studb set name = ? where id = ?");
            sql.setObject(1, "kk");
            sql.setObject(2, 7);
            sql.executeUpdate();
            // sql.executeUpdate("delete from studb where id = ?");
            // sql = con.prepareStatement("delete from `studb` where id = ?");
            // sql.setObject(1, 3);
            // sql.executeUpdate();
            sql = con.prepareStatement("select * from studb ");
            res = sql.executeQuery();
            System.out.println("the data after add,edit,delete:");
            while (res.next()) {
                String id = res.getString(1);
                String name = res.getString(2);
                String sex = res.getString(3);
                String grade = res.getString(4);
                String term = res.getString(5);
                String math = res.getString(6);
                String cpp = res.getString(7);
                String js = res.getString(8);
                System.out.print("id: " + id);
                System.out.print(" name: " + name);
                System.out.print(" sex: " + sex);
                System.out.print(" grade: " + grade);
                System.out.print(" term: " + term);
                System.out.print(" math: " + math);
                System.out.print(" cpp: " + cpp);
                System.out.println(" js: " + js);
            }

        } catch (Exception p) {
            p.printStackTrace();
        }
    }
}
