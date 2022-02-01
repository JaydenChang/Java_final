package java_final.util;

import java.sql.*;

// import java_final.*;
public class DBUtil {
    private static DBUtil db;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private DBUtil() {

    }

    public static DBUtil getDBUtil() {
        if (db == null) {
            db = new DBUtil();
        }
        return db;
    }

    public int executeUpdate(String sql) {
        int result = -1;
        if (getConnection() == null) {
            return result;
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int executeUpdate(String sql, Object[] obj) {
        int result = -1;
        if (getConnection() == null) {
            return result;
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                preparedStatement.setObject(i + 1, obj[i]);
            }
            result = preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet executeQuery(String sql) {
        if (getConnection() == null) {
            return null;
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet executeQuery(String sql, Object[] obj) {
        if (getConnection() == null) {
            return null;
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                preparedStatement.setObject(i + 1, obj[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean execute(String sql) {
        if (getConnection() == null) {
            return false;
        }
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName(AppConst.JDBC_DRIVER);
                connection = DriverManager.getConnection(AppConst.JDBC_URL, AppConst.JDBC_USERNAME,
                        AppConst.JDBC_PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
