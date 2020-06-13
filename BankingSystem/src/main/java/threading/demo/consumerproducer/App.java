package threading.demo.consumerproducer;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Blocking queue / producer consumenr pattern
 * <p>
 * One or more threads keep producing things
 * and puts things in the queue for common data share
 * <p>
 * and other threads remove thing ferom this queue to process it
 */
public class App {

    /**
     * stores data in an array list
     * FIFO
     * Thread safe so no worries for sync
     */
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);


    /**
     * this could be a thread that check for sms messages people sending and that has been put in to the queue
     *
     * @throws InterruptedException
     */
    private static void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            /// if quque is full this would nicely wait till it concuemts or removed from the wueue
            queue.put(random.nextInt(100));
        }


    }

    /**
     * we need to access thos text messages from the queue and send to the destination
     */
    private static void consumer() throws InterruptedException {
        // randomly take items from the queu
        Random random = new Random();
        while (true) {

            // takes intergers off from the quwe only once in a while
            Thread.sleep(100);

            // once a second
            // taking things off 10 times a second
            if (random.nextInt(10) == 0) {
                // if quque has nothing this nicely wait till queue gets one
                Integer value = queue.take();

                System.out.println("taken value : " + value + " Queue size : " + queue.size());
            }
        }
    }


    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
