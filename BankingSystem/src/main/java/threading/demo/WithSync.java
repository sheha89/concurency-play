package threading.demo;

public class WithSync {

    private int count = 0;

    private synchronized void increment(){
        count++;
    }

    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        // System.out.println(count); if only up to this line count will be 0 as sout executes before any of the threads run

        try {
            t1.join(); // waits till thread dies
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count); // Wont be 20000 consistently as concurrent reads while other operations
    }

    public static void main(String[] args) {
        new WithSync().doWork();
    }
}
