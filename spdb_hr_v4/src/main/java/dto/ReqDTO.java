package dto;

import bean.Resume;
import lombok.Data;

import java.util.List;

/**
 * Created by guyaren
 */
@Data
public class ReqDTO {
    /**
     * 增加简历请按----------1
     * 删除简历请按----------2
     *      按编号----------1
     *      按姓名----------2
     *      按学校----------3
     *      按状态----------4
     *      退出------------5
     * 修改简历请按----------3
     * 查询简历请按----------4
     *     按编号----------1
     *     按姓名----------2
     *     按学校----------3
     *     按状态----------4
     *     按删除----------5
     *     退出------------6
     * 退出系统请按--------------5
     */
    private int indexOne;
    private int indexTwo;
    private List<String> dataStr;
    private List<Resume> dataObj;


}
