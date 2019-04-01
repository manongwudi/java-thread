package cn.wudimanong.thread.singleton;

//final不允许被继承
public final class SingleTonLhangshiSync {
    //实例变量
    private byte[] data = new byte[1024];

    //定义实例，但是不直接初始化
    private static SingleTonLhangshiSync instance = null;

    //私有化构造函数，不允许外部NEW
    private SingleTonLhangshiSync() {

    }

    //向getInstance方法加入同步控制，每次只能有一个线程能够进入
    public static synchronized SingleTonLhangshiSync getInstance() {
        if (null == instance) {
            instance = new SingleTonLhangshiSync();
        }
        return instance;
    }
}
