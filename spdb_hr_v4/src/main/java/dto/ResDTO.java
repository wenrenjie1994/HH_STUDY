package dto;

import lombok.Data;

/**
 * Created by guyaren
 */
@Data
public class ResDTO {
    /**
     * code = 0 : 全部失败
     * code = 1 : 部分失败
     * code = 2 ：成功
     */
    private int code;
    private int success;
    private int wrong;
    private String data;


    @Override
    public String toString() {
        return "ResDTO{" +
                "code=" + code +
                ", success=" + success +
                ", wrong=" + wrong +
                ", data='" + data + '\'' +
                '}';
    }
}
