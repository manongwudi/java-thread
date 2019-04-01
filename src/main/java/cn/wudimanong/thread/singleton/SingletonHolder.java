package cn.wudimanong.thread.singleton;

//不允许被继承
public final class SingletonHolder {
    //实例变量
    private byte[] data = new byte[1024];

    private SingletonHolder() {

    }

    //在静态内部类中持有单例类的实例，并且可直接被初始化
    private static class Holder {
        private static SingletonHolder instance = new SingletonHolder();
    }

    //调用getInstance方法，事实上是获得Holder的instance静态属性
    public static SingletonHolder getInstance() {
        return Holder.instance;
    }
}
