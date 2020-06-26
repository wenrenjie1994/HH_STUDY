import java.io.UnsupportedEncodingException;

/**
 * @author MartinVon
 * @create 2020-06-26-16:59
 * <p>
 * 测试字符集
 */
public class Test4 {

    public static void main(String[] args) {

        try {
            String string = new String(new byte[]{(byte) 0xd7, (byte) 0xd6, (byte) 0xb7, (byte) 0xfb, (byte) 0xb1, (byte) 0xe0, (byte) 0xc2, (byte) 0xeb}, "gbk");
            System.out.println(string);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
