package en;

/**
 * @Author: chenlei
 * @Date: 2020/7/17 17:14
 */
public enum OperationEnum {
    //增加
    ADD(1,"增加用户"),
    DELETE(2,"删除用户"),
    UPDATE(3,"更新用户"),
    SELECT(4,"查询用户"),
    SELECT_ALL(5,"查询所有用户");
    int code;
    String operation;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    OperationEnum(int code, String operation) {
        this.code = code;
        this.operation = operation;
    }
}
