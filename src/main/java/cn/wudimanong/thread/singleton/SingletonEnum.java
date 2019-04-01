package cn.wudimanong.thread.singleton;

public class SingletonEnum {
    //实例变量
    private byte[] data = new byte[1024];

    private SingletonEnum() {

    }

    //使用枚举充当Holder
    private enum EnumHolder {
        INSTANCE;
        private SingletonEnum instance;

        EnumHolder() {
            this.instance = new SingletonEnum();
        }

        private SingletonEnum getInstance() {
            return instance;
        }
    }

    public static SingletonEnum getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }
}
