package cn.wudimanong.thread.volatitle;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author joe
 */
public class VolatileEntityTest {

    //使用volatile修饰共享资源
    private static volatile VolatileEntity volatileEntity = VolatileEntity.getInstance();

    private static final CountDownLatch latch = new CountDownLatch(10);


    public static void main(String args[]) throws InterruptedException {
        //启动一个线程，当发现local_value与init_value不同时，则输出init_value被修改的值
        new Thread(() -> {
            int localValue = volatileEntity.init_value;
            while (localValue < VolatileEntity.max) {
                if (volatileEntity.init_value != localValue) {
                    System.out.printf("The init_value is update ot [%d]\n", volatileEntity.init_value);
                    //对localValue进行重新赋值
                    localValue = volatileEntity.init_value;
                }
            }
        }, "Reader").start();

        //启动updater线程，主要用于对init_value的修改，当local_value=5的时候退出生命周期
        new Thread(() -> {

            int localValue = volatileEntity.init_value;
            ;
            while (localValue < VolatileEntity.max) {
                //修改init_value
                System.out.printf("The init_value will be changed to [%d]\n", ++localValue);
                volatileEntity.init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }
}
