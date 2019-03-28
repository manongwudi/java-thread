package cn.wudimanong.thread.jucpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Joe
 */
public class FixThreadPoolDemo {

    public static void main(String args[]) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i <= 100; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "[runing done]");
            });
        }
    }
}
