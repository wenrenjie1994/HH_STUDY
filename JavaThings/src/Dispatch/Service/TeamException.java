package Dispatch.Service;

/**
 * @Description 自定义异常类
 * @author
 * @date 2020.7.29 17:10
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387514229948L;

    public TeamException() {
        super();
    }
    public TeamException(String msg) {
        super(msg);
    }
}
