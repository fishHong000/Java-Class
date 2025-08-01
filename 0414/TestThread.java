public class TestThread {
    public static void main(String[] argv) {
        Thread x = new PrintThread(); // polymorphism
        x.start(); // thread start, like main() but call Thread.run()
        ToImplements a = new ToImplements();
        Thread y = new Thread(a);
        // y.setPriority(3);
        y.start();
        for (int i = 0; i <= 50; i++) {
            System.out.println("main" + i);
            try {
                Thread.currentThread().sleep(2000);
            } catch(Exception err) {
            }
        }
        System.out.println("Main end");
    }
}
class PrintThread extends Thread {
    public void run() { // override Thread.run()
        for (int i = 0; i < 50; i++) {
            System.out.println("hello"+i);
            try {
                sleep(3000); // call parent's sleep() function
            } catch(Exception err) {
            }
        }
        System.out.println("Thread end");
    }
}   
// try catch 才能使用 sleep
class ToImplements implements Runnable {
    public void run() { // override Thread.run()
        for (int i = 0; i < 50; i++) {
            System.out.println("test"+" "+i);
            // try {
                // sleep(3000); // call parent's sleep() function
            // } catch(Exception err) {
            // }
        }
        System.out.println("Runnable Thread end");
    }       
}    