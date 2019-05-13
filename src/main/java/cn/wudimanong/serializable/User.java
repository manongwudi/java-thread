package cn.wudimanong.serializable;

import java.io.Serializable;

/**
 * @author joe
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2L;

    private String userId;
    private String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
