package java_final.view;

import java.awt.event.*;

import java_final.base.*;
import java_final.dao.*;
import java_final.model.*;
import java_final.util.*;

public class DeleteModel {
    public DeleteModel(String name) {
        init(name);
    }

    private void init(String name) {
        Student stu = new Student();
        buildStudent(stu, name);
        boolean isSuccess = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO)).delete(stu);
        if (isSuccess) {
            // setEmpty();
            if (MainView.currPageNum < 0 || MainView.currPageNum > 99) {
                MainView.currPageNum = 1;
            }
            String[][] result = ((StudentDAO) BaseDAO.getAbilityDAO(DAO.StudentDAO))
                    .list(MainView.currPageNum);
            MainView.initJTable(MainView.table, result);
        }

    }

    private void buildStudent(Student stu, String name) {
        stu.setName(name);
    }
}
