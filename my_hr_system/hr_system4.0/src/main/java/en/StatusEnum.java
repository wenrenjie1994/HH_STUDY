package en;

/**
 * @Author: chenlei
 * @Date: 2020/7/17 17:00
 */
public enum StatusEnum {
    //成功
    SUCCESS(200,"请求成功"),
    //简历不存在
    RESUME_NOT_EXIT(5001,"简历不存在"),
    //简历已经存在
    RESUME_EXIT(5002,"已经存在该简历"),
    //系统中不存在简历
    NO_RESUME_EXIT(5003,"系统中不存在简历"),

    //数据库操作错误
    DATABASE_ERROR(5100,"数据库操作错误");

    private int code;
    private String message;


    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return this.code;
    }
    public String getMessage(){
        return message;
    }
}
