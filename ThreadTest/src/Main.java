import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        for (int i = 0; i < 4; i++) {
            TestThread t = new TestThread();
            t.start();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {

                Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

                for (Thread t : threadSet) {
                    if (t.getClass().getName().equals("TestThread")) {
                        t.interrupt();
                    }
                }

                for (Thread t : threadSet) {
                    if (t.getClass().getName().equals("TestThread")) {
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

    }
}
