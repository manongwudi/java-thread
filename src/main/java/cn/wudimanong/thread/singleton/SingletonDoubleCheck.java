package cn.wudimanong.thread.singleton;

import java.net.Socket;
import java.sql.Connection;

//final不允许被继承
public final class SingletonDoubleCheck {
    //实例变量
    private byte[] data = new byte[1024];

    //定义实例，但是不直接初始化
    private static volatile SingletonDoubleCheck instance = null;

    Connection con;
    Socket socket;

    //私有化构造函数，不允许外部NEW
    private SingletonDoubleCheck() {
        this.con = con;//初始化
        this.socket = socket;//初始化

    }

    public static SingletonDoubleCheck getInstance() {
        //当instance为null时，进入同步代码块，同时该判断避免了每次都需要进入同步代码块，可以提高效率
        if (null == instance) {
            //只有一个线程能够获得SingletonDoubleCheck.class关联的monitor
            synchronized (SingletonDoubleCheck.class) {
                //判断如果instance为null则创建
                if (null == instance) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
