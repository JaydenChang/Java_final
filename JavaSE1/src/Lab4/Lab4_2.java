package Lab4;

public class Lab4_2 {
    public static void main(String[] args) {
        Student s1 = new Student("Lida", "101", "Software Engine");
        Student s2 = new Student("Lily", "102", "Education");
        System.out.println(s1);
        System.out.println(s2);

    }
}

class Student {
    String name, num, major;

    public Student(String name, String num, String major) {
        this.name = name;
        this.num = num;
        this.major = major;
    }

    @Override
    public String toString() {
        return "name: " + name + ", num: " + num + ", major: " + major;
    }
}