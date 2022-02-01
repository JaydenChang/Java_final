package java_final.util;

public class AppConst {
    // jdbc
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "admin";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // student
    public static final String studentName = "姓名";
    public static final String studentStuNo = "学号";
    public static final String studentDepartment = "院系";
    public static final String studentTotalMark = "总学分";
    public static final String studentGPA = "GPA";
    public static final String studentLinuxPoint = "Linux绩点";
    public static final String studentCppPoint = "C++绩点";
    public static final String studentJavaPoint = "Java绩点";

    // login view
    public static final String loginTitle = "登陆界面";
    public static final String loginUserName = "用户名";
    public static final String loginPassword = "密码";
    public static final String loginBtn = "登录";
    public static final String resetBtn = "重置";

    // main view
    public static final String mainViewTitle = "学生信息管理系统";
    public static final String mainViewPageNum = "/99";
    public static final String mainViewFindLabel = "查询结果";
    public static final String mainViewFirst = "首页";
    public static final String mainViewLast = "末页";
    public static final String mainViewPre = "上一页";
    public static final String mainViewNext = "下一页";
    public static final String paramFindConition = "";
    public static final String paramFind = "查找";
    public static final String paramAdd = "添加";
    public static final String paramDelete = "删除";
    public static final String paramUpdate = "更新";
    public static final String MainViewInfoBtn = "详细信息";

    // add view
    public static final String addViewTitle = "添加学生信息";
    public static final String addViewAddBtn = "添加";
    public static final String ExitBtn = "退出";

    // update view
    public static final String updateViewTitle = "更新学生信息";
    public static final String updateViewUpdateBtn = "更新";

    // delete view
    public static final String deleteViewTitle = "删除学生信息";
    public static final String deleteViewDeleteBtn = "删除";

    // info view
    public static final String infoViewTitle = "详细信息";
    public static final String infoViewExportBtn = "导出";
}
