import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //List<TestThread> threadList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            TestThread t = new TestThread();
            //threadList.add(t);
            t.start();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {

            Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

            public void run() {
                for (Thread t : threadSet) {
                    if (t.getClass().getName() == "TestThread") {
                        t.interrupt();
                    }
                }

                for (Thread t : threadSet) {
                    if (t.getClass().getName() == "TestThread") {
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
