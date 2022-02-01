package java_final.base;

import java.sql.*;
import java_final.util.*;
import java_final.dao.*;
// import java_final.util.*;

public class BaseDAO {
    protected final DBUtil db = DBUtil.getDBUtil();
    protected ResultSet resultSet;
    private static BaseDAO baseDAO;

    public BaseDAO() {
        init();
    }

    private void init() {
    }

    public static synchronized BaseDAO getAbilityDAO(DAO dao) {
        switch (dao) {
            case AdminDAO:
                if (baseDAO == null || baseDAO.getClass() != AdminDAO.class) {
                    baseDAO = AdminDAO.getInstance();
                }
                break;
            case StudentDAO:
                if (baseDAO == null || baseDAO.getClass() != StudentDAO.class) {
                    baseDAO = StudentDAO.getInstance();
                }
                break;
            default:
                break;
        }
        return baseDAO;
    }

    protected void destroy() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
