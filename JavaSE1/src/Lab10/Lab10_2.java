package Lab10;

// import java.util.*;

public class Lab10_2 extends Thread {
    public static void main(String[] args) {
        new Lab10_2();
    }

    public Lab10_2() {
        Thread ta = new Thread();
        Thread tb = new Thread();
        Thread tc = new Thread();
        Thread td = new Thread();
        long nano[] = new long[4];
        ta.start();
        nano[0] = System.nanoTime();
        // System.out.println(Thread.currentThread().getId() + ",the current time " +
        // nano[0]);
        tb.start();
        nano[1] = System.nanoTime();
        // System.out.println(Thread.currentThread().getId() + ",the current time " +
        // nano[1]);
        tc.start();
        nano[2] = System.nanoTime();
        // System.out.println(Thread.currentThread().getId() + ",the current time " +
        // nano[2]);
        td.start();
        nano[3] = System.nanoTime();
        // System.out.println(Thread.currentThread().getId() + ",the current time " +
        // nano[3]);
        for (int i = 0; i < 4; i++) {
            System.out.println("no." + i + " is running, the current time: " + nano[i]);
        }
    }
}