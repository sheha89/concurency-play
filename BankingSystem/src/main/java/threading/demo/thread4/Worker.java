package threading.demo.thread4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    /**
     * with sync
     * Data updates properly but takes time more than twice as without sync
     * this is due to sync aquires intrinc lock/monitor lock before every update on work object.
     * second thread has to wait till other thread realeases
     *
     * since the lock is on the object it prevents run both methods or updating both the separate lists
     */


/*    public synchronized void stageOne() {
        try {
            Thread.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list1.add(random.nextInt(100));
    }

    public synchronized void stageTwo() {
        try {
            Thread.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list2.add(random.nextInt(100));
    }*/

    /**
     * We should be able to allow two sperate threads execute the two separate independent methods (not same data)
     * Sepatate locks needs
     * we need seprate objects
     */

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void stageOne() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt(100));
        }
    }


    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }


    public void main() {
        System.out.println("Starting....");

        long start = System.currentTimeMillis();


        /**
         * without sync
         * Multiple threads running multiple processes
         * Shares data with multiple threads , problems due to thread interleaving
         */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time taken :" + (end - start));
        System.out.println("List 1 size : " + list1.size() + ", List 2 size : " + list2.size());
    }
}
