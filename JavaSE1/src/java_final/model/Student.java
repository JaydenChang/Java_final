package java_final.model;

public class Student {
    private int id;
    private String stuNo;
    private String name;
    private String department;
    private String totalMark;
    private String GPA;
    private String javaPoint;
    private String linuxPoint;
    private String cppPoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }

    public double calcGPA() {
        // GPA = String.valueOf((Double.valueOf(linuxPoint) + Double.valueOf(javaPoint)
        // + Double.valueOf(cppPoint)) / 3);
        return (Double.valueOf(linuxPoint) + Double.valueOf(javaPoint) + Double.valueOf(cppPoint)) / 3;
    }

    public String getGPA() {
        return GPA;
    }

    // public void setGPA(double GPA) {
    // this.GPA = String.valueOf(calcGPA());
    // }
    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public String getCppPoint() {
        return cppPoint;
    }

    public void setCppPoint(String cppPoint) {
        this.cppPoint = cppPoint;
    }

    public String getLinuxPoint() {
        return linuxPoint;
    }

    public void setLinuxPoint(String linuxPoint) {
        this.linuxPoint = linuxPoint;
    }

    public String getJavaPoint() {
        return javaPoint;
    }

    public void setJavaPoint(String javaPoint) {
        this.javaPoint = javaPoint;
    }

}
