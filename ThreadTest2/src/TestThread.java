public class TestThread implements Runnable {

  private String name;
  Thread thisThread;

  @Override
  public void run() {
    name = Thread.currentThread().getName();
    System.out.println(name + " started");
    thisThread = Thread.currentThread();
    while (true) {
      if (thisThread.isInterrupted()) {
        System.out.println(name + " has been interrupted");
        System.out.flush();
        break;
      }
    }
  }

}
