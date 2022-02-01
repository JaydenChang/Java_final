package Lab11;

import java.util.concurrent.atomic.*;

public class Lab11_1_3 implements Runnable {
    public static void main(String[] args) {
        Lab11_1_3 ll = new Lab11_1_3();
        Thread tA = new Thread(ll);
        Thread tB = new Thread(ll);
        Thread tC = new Thread(ll);
        tA.start();
        tB.start();
        tC.start();
    }

    // public int num = 10;
    public AtomicInteger num = new AtomicInteger(10);

    public void run() {
        while (true) {

            if (num.get() > 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num.getAndDecrement());
            } else {
                break;
            }
        }
    }
}
