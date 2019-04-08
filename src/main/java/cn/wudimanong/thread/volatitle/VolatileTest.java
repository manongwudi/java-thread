package cn.wudimanong.thread.volatitle;

import java.util.concurrent.CountDownLatch;

/**
 * @author joe
 */
public class VolatileTest {
    //使用volatile修饰共享资源i
    private static volatile int i = 0;

    private static final CountDownLatch latch = new CountDownLatch(10);

    private static void inc() {
        i++;
    }

    public static void main(String args[]) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int x = 0; x < 1000; x++) {
                    inc();
                }
                latch.countDown();//计数器减1
            }).start();
        }
        //等待所有的线程完成工作
        latch.await();
        System.out.println(i);
    }
}
