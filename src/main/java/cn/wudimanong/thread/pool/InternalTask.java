package cn.wudimanong.thread.pool;

/**
 * @author joe
 */
//是Runnable的一个实现，主要用于线程池内部，该类会使用到RunnableQueue,然后不断地从队列中取出某个Runnable并运行其run方法
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果当前任务为running并且没有中断，则其将不断地从queue中获取runnable，然后执行其run方法
        while (running && !Thread.currentThread().isInterrupted()) {
            Runnable task = runnableQueue.take();
            task.run();
        }
    }

    //停止当前任务，主要会在线程池的shutdown方法中使用
    public void stop() {
        this.running = false;
    }
}
