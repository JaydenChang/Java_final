package Lab10;

public class Lab10_3 extends Thread {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        Thread thread1 = new Thread(threadA);
        Thread thread2 = new Thread(threadB);
        System.out.println("the threads are born");
        thread1.start();
        thread2.start();
        System.out.println("the threads are running");
        try {
            System.out.println("force threadA run for 10s");
            thread1.join(10000);
            System.out.println("run the interruption for threadB");
            thread2.interrupt();
        } catch (Exception e) {
            System.out.println("threadB is interrupted, throw the exception");
            e.printStackTrace();
        }
    }

}

class ThreadA implements Runnable {
    String data = "ThreadA is running";

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(data + " " + i);
            try {
                Thread.sleep(1000);
                System.out.println(data + " sleep for " + i + " s");
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}

class ThreadB implements Runnable {
    String data = "ThreadB is running";

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(data + " " + i);
            try {
                Thread.sleep(1000);
                System.out.println(data + " sleep for " + i + " s");
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}