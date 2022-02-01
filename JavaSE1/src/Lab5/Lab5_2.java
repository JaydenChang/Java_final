package Lab5;

public class Lab5_2 {
    public static void main(String[] args) {
        // 成员内部类
        Lab5_2 ll = new Lab5_2();
        CarTest_Inner car1 = ll.new CarTest_Inner();
        car1.run();
        car1.CarRun();
        System.out.println();

        // 局部内部类
        ll.methodClass();

        System.out.println();
        // 匿名类
        ll.test(new Car() {
            public void run() {
                System.out.println("anonymous class method");
            }
        });
    }

    public void test(Car cc) {
        cc.run();
    }

    public class CarTest_Inner implements Car {
        @Override
        public void run() {
            System.out.println("inner class run");
        }

        public void CarRun() {
            System.out.println("CarTest CarRun");
        }
    }

    public void methodClass() {
        class Me implements Car {
            @Override
            public void run() {
                System.out.println("method class run");
            }

            public void CarRun() {
                System.out.println("mmm CarRun");
            }
        }
        Me mmm = new Me();
        mmm.run();
        mmm.CarRun();
    }
}

interface Car {
    public void run();
}

class CarTest implements Car {
    @Override
    public void run() {
        System.out.println("inner class run");
    }

    public void CarRun() {
        System.out.println("CarTest CarRun");
    }
}