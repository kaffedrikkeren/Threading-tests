public class TestThread extends Thread {

  private String name;
  private volatile boolean isInterrupted = false;
  Thread thisThread;

  @Override
  public void run() {
    name = Thread.currentThread().getName();
    System.out.println(name + " started");
    thisThread = Thread.currentThread();

    while (true) {
      //System.out.println(name + " works, internal isInterrupted is " + thisThread.isInterrupted());
      if (isInterrupted) {
        System.out.println(name + " has been interrupted");
        break;
      }
    }

  }

  @Override
  public void interrupt() {
    System.out.println(name + " got an interrupt call");
    isInterrupted = true;
  }
}
