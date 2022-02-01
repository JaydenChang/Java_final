package Lab5;

public class Lab5_1 {
    public static void main(String[] args) {
        Person fa = new Father();
        Person so = new Son();
        fa.say();
        // fa.drive();
        System.out.println();
        so.say();
        // so.drive();
    }
}

abstract class Person {
    String name, gender;
    int age;

    abstract void say();
}

class Father extends Person {
    String name, gender;
    int age;

    @Override
    void say() {
        System.out.println("Chinese");
    }

    void drive() {
        System.out.println("car");
    }
}

class Son extends Person {
    String name, gender;
    int age;

    @Override
    void say() {
        System.out.println("English Chinese");
    }

    void drive() {
        System.out.println("airplane");
    }
}