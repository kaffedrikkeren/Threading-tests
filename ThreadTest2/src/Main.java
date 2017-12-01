import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new TestThread());
            t.start();
            threadList.add(t);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {

                for (Thread t : threadList) {
                    t.interrupt();
                }

                for (Thread t : threadList) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }
}
