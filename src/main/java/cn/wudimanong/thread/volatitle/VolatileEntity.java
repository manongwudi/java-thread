package cn.wudimanong.thread.volatitle;

/**
 * @author joe
 */
public class VolatileEntity {
    //使用volatile修饰共享资源i
    //类变量
    final static int max = 5;

    int init_value = 0;

    public static int getMax() {
        return max;
    }

    public int getInit_value() {
        return init_value;
    }

    public void setInit_value(int init_value) {
        this.init_value = init_value;
    }

    private static class VolatileEntityHolder {

        private static VolatileEntity instance = new VolatileEntity();
    }

    public static VolatileEntity getInstance() {
        return VolatileEntityHolder.instance;
    }
}
