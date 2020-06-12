package Middle_Exception.Category;

/**
 * @Author lee
 * @Date 2020/6/12 7:23 AM
 * 错误不需要强制捕捉
 * 错误属于系统级别的异常，如OutOfMemoryError
 **/


public class Error {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
        for(int i =0; i<Integer.MAX_VALUE;i++){
            s.append("a");
        }
    }
}
