package threading.demo.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

    private int id;

    Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Starting id : " + id);

        // Could be a server handling requests or processing files

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed id : " + id);
    }
}


public class App {

    public static void main(String[] args) {

        // need 10 processors work through 10 different tasks using thread class
        // Use executor class instead


        // two workers many tasks. once finish one start on another
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Executor service has his own managerial thread


        /**
         * Thera is alot of overhead in starting threads using thread pools you could recycle threads
         */

        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }
// Executor service has his own managerial thread
        // stpo excepting new tasks
        executor.shutdown();
        ;

        System.out.println("All tasks submitted...");

        // Stays one day till you finish all tasks
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed...");
    }
}
