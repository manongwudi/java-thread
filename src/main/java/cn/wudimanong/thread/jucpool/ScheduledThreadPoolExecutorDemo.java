package cn.wudimanong.thread.jucpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Joe
 */
public class ScheduledThreadPoolExecutorDemo {

    public static void main(String args[]) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        for (int i = 0; i <= 20; i++) {
            pool.schedule(() -> {
                System.out.println(Thread.currentThread().getName() + "[runing done]");
            }, 10, TimeUnit.SECONDS);
        }
    }
}
