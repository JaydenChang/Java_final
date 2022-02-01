package Lab11;

import java.util.*;
import java.util.concurrent.*;

public class Lab11_2 {
    public static void main(String[] args) {
        printChar pt[] = new printChar[20];
        for (int i = 0; i < 20; i++) {
            pt[i] = new printChar(i);
        }
        // 为便于观察就设了20个线程
        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            executor.execute(pt[i]);
            long end = System.currentTimeMillis();
            System.out.println("\n\ncost time: " + (end - start) + "\n");
        }
        executor.shutdown();
    }
}

class printChar implements Runnable {
    private long num;

    public printChar(long c) {
        num = c;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print((num));
        }
        System.out.println();
    }
}