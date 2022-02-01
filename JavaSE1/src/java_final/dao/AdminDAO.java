package java_final.dao;

import java.sql.*;
import java_final.base.*;

public class AdminDAO extends BaseDAO {
    private static AdminDAO ad = null;

    public static synchronized AdminDAO getInstance() {
        if (ad == null) {
            ad = new AdminDAO();
        }
        return ad;
    }

    public boolean queryForLogin(String username, String password) {
        boolean result = false;
        if (username.length() == 0 || password.length() == 0) {
            return result;
        }
        String sql = "select * from admin where username=? and password=?";
        String[] param = { username, password };
        resultSet = db.executeQuery(sql, param);
        try {
            if (resultSet.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return result;
    }
}
