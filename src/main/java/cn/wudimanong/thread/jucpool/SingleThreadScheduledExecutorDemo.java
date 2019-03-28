package cn.wudimanong.thread.jucpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Joe
 */
public class SingleThreadScheduledExecutorDemo {
    public static void main(String args[]) {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i <= 20; i++) {
            pool.scheduleAtFixedRate(() -> {
                System.out.println(Thread.currentThread().getName() + "[runing done]");
            }, 1, 1, TimeUnit.SECONDS);
        }
    }
}
