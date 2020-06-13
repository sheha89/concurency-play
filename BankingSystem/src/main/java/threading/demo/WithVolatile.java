package threading.demo;


import java.util.Scanner;

class Processor extends Thread {

    /**
     * some computers this variable caches hence execution never stops. Voltile solves this
     * Main thread spawns another thread and run executes in spawned threads but variable is shred
     * To stop running you need shutdown gracefull
     * <p>
     * while spawned reads , main thread writes to the variable  ava doesnt like one thread modifying anothers data
     * Spawned thread tend to work on only the changes it has done to the variable
     */


//    private boolean running = true;

    // volatile prevent threads cacheing variable when they are not changed withing the thread and changed from othre threads
    private volatile boolean running = true;


    public void run() {

        // tend to asssumes runiing is always true if not for volatile
        while (running) {
            System.out.println("hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class WithVolatile {


    public static void main(String[] args) {
        Processor p1 = new Processor();
        p1.start();

        System.out.println("Press return to stop...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        //while spawned reads , main thread writes to the variable  ava doesnt like one thread modifying anothers data
        p1.shutdown();
    }


}
