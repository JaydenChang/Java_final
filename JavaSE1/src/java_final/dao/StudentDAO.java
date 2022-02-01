package java_final.dao;

import java.sql.*;
import java.util.*;

import java_final.base.*;
import java_final.model.*;

public class StudentDAO extends BaseDAO {
    private final int fieldNum = 9;
    private final int showNum = 15;
    private static StudentDAO sd = null;

    public static synchronized StudentDAO getInstance() {
        if (sd == null) {
            sd = new StudentDAO();
        }
        return sd;
    }

    // update
    public boolean update(Student stu) {
        boolean result = false;
        if (stu == null) {
            return result;
        }
        try {
            // check
            if (queryByStuNo(stu.getStuNo()) == 0) {
                return result;
            }
            // update
            String sql = "update student set department=?,totalMark=?,linuxPoint=?,cppPoint=?,javaPoint=?,GPA=? where name=? and stuNo=?";
            String[] param = { stu.getDepartment(), stu.getTotalMark(),
                    stu.getLinuxPoint(), stu.getCppPoint(), stu.getJavaPoint(), stu.getGPA(), stu.getName(),
                    stu.getStuNo() };
            int rowCount = db.executeUpdate(sql, param);
            if (rowCount == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return result;
    }

    // delete
    public boolean delete(Student stu) {
        boolean result = false;
        if (stu == null) {
            return result;
        }
        String sql = "delete from student where name=?";
        String[] param = { stu.getName() };
        int rowCount = db.executeUpdate(sql, param);
        if (rowCount == 1) {
            result = true;
        }
        destroy();
        return result;
    }

    // add
    public boolean add(Student stu) {
        boolean result = false;
        if (stu == null) {
            return result;
        }
        try {
            // check
            if (queryByStuNo(stu.getStuNo()) == 1) {
                return result;
            }
            // insert
            String sql = "insert into student(name,stuNo,department,totalMark,linuxPoint,cppPoint,javaPoint,GPA) values (?,?,?,?,?,?,?,?)";
            String[] param = { stu.getName(), stu.getStuNo(), stu.getDepartment(), stu.getTotalMark(),
                    stu.getLinuxPoint(), stu.getCppPoint(), stu.getJavaPoint(), stu.getGPA() };
            if (db.executeUpdate(sql, param) == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return result;
    }

    private void buildList(ResultSet rs, List<Student> list, int i) throws SQLException {
        Student stu = new Student();
        stu.setId(i + 1);
        stu.setName(rs.getString("name"));
        stu.setDepartment(rs.getString("department"));
        stu.setStuNo(rs.getString("stuNo"));
        stu.setTotalMark((rs.getString("totalMark")));
        stu.setLinuxPoint(rs.getString("linuxPoint"));
        stu.setCppPoint((rs.getString("cppPoint")));
        stu.setJavaPoint((rs.getString("javaPoint")));
        // stu.setGPA(Double.parseDouble(rs.getString("GPA")));
        stu.setGPA(rs.getString("GPA"));
        list.add(stu);
    }

    private void buildResult(String[][] result, List<Student> stus, int j) {
        Student stu = stus.get(j);
        result[j][0] = String.valueOf(stu.getId());
        result[j][1] = String.valueOf(stu.getName());
        result[j][2] = String.valueOf(stu.getStuNo());
        result[j][3] = String.valueOf(stu.getDepartment());
        result[j][4] = String.valueOf(stu.getTotalMark());
        result[j][5] = String.valueOf(stu.getLinuxPoint());
        result[j][6] = String.valueOf(stu.getCppPoint());
        result[j][7] = String.valueOf(stu.getJavaPoint());
        result[j][8] = String.valueOf(stu.getGPA());
    }

    // query by name
    public String[][] queryByName(String name) {
        String[][] result = null;
        if (name.length() < 0) {
            return result;
        }
        List<Student> stus = new ArrayList<Student>();
        int i = 0;
        String sql = "select * from student where name like ? ";
        String[] param = { "%" + name + "%" };
        resultSet = db.executeQuery(sql, param);
        try {
            while (resultSet.next()) {
                buildList(resultSet, stus, i);
                i++;
            }
            if (stus.size() > 0) {
                result = new String[stus.size()][fieldNum];
                for (int j = 0; j < stus.size(); j++) {
                    buildResult(result, stus, j);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return result;
    }

    // query by stuNo
    private int queryByStuNo(String stuNo) throws SQLException {
        int result = 0;
        if ("".equals(stuNo) || stuNo == null) {
            return result;
        }
        String checkSql = "select * from student where stuNo=?";
        String[] checkParam = { stuNo };
        resultSet = db.executeQuery(checkSql, checkParam);
        if (resultSet.next()) {
            result = 1;
        }
        return result;
    }

    // query
    public String[][] list(int pageNum) {
        String[][] result = null;
        if (pageNum < 1) {
            return result;
        }
        List<Student> stus = new ArrayList<Student>();
        int i = 0;
        int beginNum = (pageNum - 1) * showNum;
        String sql = "select * from student limit ?,?";
        Integer[] param = { beginNum, showNum };
        resultSet = db.executeQuery(sql, param);
        try {
            while (resultSet.next()) {
                buildList(resultSet, stus, i);
                i++;
            }
            if (stus.size() > 0) {
                result = new String[stus.size()][fieldNum];
                for (int j = 0; j < stus.size(); j++) {
                    buildResult(result, stus, j);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return result;
    }
}
