package cn.wudimanong.thread.jucpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Joe
 */
public class WorkStealingPoolDemo {

    public static void main(String args[]) {
        ExecutorService pool = Executors.newWorkStealingPool(10);
        for (int i = 0; i <= 20; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "[running done]");
            });
        }
    }

}
