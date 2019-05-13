package cn.wudimanong.serializable;

import java.io.*;

/**
 * @author joe
 */
public class SerializableTest {

    /**
     * 将User对象作为文本写入磁盘
     */
    public static void writeObj() {
        User user = new User("1001", "Joe");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/guanliyuan/user2.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将类从文本中提取并赋值给内存中的类
     */
    public static void readObj() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/guanliyuan/user.txt"));
            try {
                Object object = objectInputStream.readObject();
                User user = (User) object;
                System.out.println(user);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {
        readObj();
    }
}
