package Lab11;

public class Lab11_1_1 implements Runnable {
    public static void main(String[] args) {
        Lab11_1_1 ll = new Lab11_1_1();
        Thread tA = new Thread(ll);
        Thread tB = new Thread(ll);
        Thread tC = new Thread(ll);
        tA.start();
        tB.start();
        tC.start();
    }

    int num = 10;

    public void run() {
        while (true) {
            if (num > 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num--);
            } else {
                break;
            }
        }
    }
}
