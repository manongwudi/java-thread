package cn.wudimanong.thread;

/**
 * @author Joe
 */
public class DaemonThread01 {

    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                    System.out.println("守护线程¬");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.setDaemon(true);//将thread设置为守护线程
        thread.start();
        Thread.sleep(2000);
        System.out.println("Main thread finished lifecycle.");
    }
}
