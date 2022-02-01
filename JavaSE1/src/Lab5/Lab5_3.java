package Lab5;

public class Lab5_3 {
    public static void main(String[] args) {
        (new Lab5_3()).test();
    }

    public void test() {
        try {
            int a = 1 / 0;
            System.out.println("this command won't be run");
            System.out.println(a);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("can't be divided by 0");
        } finally {
            System.out.println("the program ends");
        }
    }
}
