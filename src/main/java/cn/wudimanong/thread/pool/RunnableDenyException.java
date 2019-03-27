package cn.wudimanong.thread.pool;

/**
 * @author joe
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }

}
