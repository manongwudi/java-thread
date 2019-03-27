package cn.wudimanong.thread.pool;

/**
 * @author joe
 */
@FunctionalInterface
public interface ThreadFactory {

    //创建线程的方法
    Thread createThread(Runnable runnable);

}
