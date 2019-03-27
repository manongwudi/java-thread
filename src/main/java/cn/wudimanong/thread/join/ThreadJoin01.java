package cn.wudimanong.thread.join;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Joe
 */
public class ThreadJoin01 {

    public static void main(String[] args) throws InterruptedException {
        //定义两个线程，保存到数组
        List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin01::create).collect(Collectors.toList());
        //启动着两个线程
        threads.forEach(Thread::start);

        //执行这两个线程的join方法
        for (Thread thread : threads) {
            thread.join();
        }

        //main线程循环输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }
    }

    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        }, String.valueOf(seq));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
