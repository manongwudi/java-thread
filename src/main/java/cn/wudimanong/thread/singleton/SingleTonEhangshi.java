package cn.wudimanong.thread.singleton;

//final不允许被继承
public final class SingleTonEhangshi {
    //实例变量
    private byte[] data = new byte[1024];

    //在定义实例对象时直接初始化
    private static SingleTonEhangshi instance = new SingleTonEhangshi();

    //私有化构造函数，不允许外部NEW
    private SingleTonEhangshi() {

    }

    public static SingleTonEhangshi getInstance() {
        return instance;
    }

    public static void main(String args[]) {
        System.out.println("hash-code:" + getInstance().hashCode());
    }
}
