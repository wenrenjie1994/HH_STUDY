package Middle_Exception.SelfDefineException;

/**
 * @Author lee
 * @Date 2020/6/12 8:22 AM
 **/


public class MyStringBuffer {
    int capacity = 16;
    int length = 0;
    char[] value;

    // 构造函数1
    public MyStringBuffer() {
        value = new char[capacity];
    }

    //构造函数2
    public MyStringBuffer(String str) {
        this();//调用上一个构造函数。只能用于第一行
        // this 关键字是类内部当中对自己的一个引用，可以方便类中方法访问自己的属性；如this.name

        //边界，空
        if (str == null) {
            return;
        }
        //容量不够
        if (capacity < str.length()) {
            //因为已经调用了上一个构造函数，所以，value已经有长度
            capacity = value.length * 2;
            // capacity更新后，value需要同步更新
            value = new char[capacity];

        }
        //如果容量够用
        if (capacity >= str.length()) {
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        }

        //长度
        length = str.length();
    }

//    public void insert(int pos, char b) throws Exception {
//        //这是个什么写法？
//        insert(pos, String.valueOf(b));
//    }
//
//    public void delete(int start) throws Exception {
//        // 此处应该写错了
//        delete(start, length);
//    }

    public int length() {
        return length;
    }

    public String toString() {
        char[] realValue = new char[length];
        System.arraycopy(value, 0, realValue, 0, length);
        return new String(realValue);
    }

    static class IndexIsNegativeException extends Exception {
        public IndexIsNegativeException() {

        }

        public IndexIsNegativeException(String msg) {
            super(msg);
        }

    }

    static class IndexIsOutOfRangeException extends Exception {
        public IndexIsOutOfRangeException() {

        }

        public IndexIsOutOfRangeException(String msg) {
            super(msg);
        }

    }

    public void delete(int start, int end) throws Exception {
        if (start < 0 | end < 0) {
            throw new IndexIsNegativeException("下标为负异常");
        }

        if (start > length | length < end | start > end) {
            throw new IndexIsOutOfRangeException("下标超出范围异常");
        }
        System.arraycopy(value, end, value, start, length - end);
        length = end - start;
    }

    public void insert(int pos, String str) throws Exception {
        if (pos < 0) {
            throw new IndexIsNegativeException("下标为负异常");
        }

        if (pos > length) {
            throw new IndexIsOutOfRangeException("下标超出范围异常");
        }

        if (str == null) {
            throw new NullPointerException("空");
        }
        while (length + str.length() > capacity) {
            capacity = (int) ((length + str.length()) * 1.5f);//1.5f是什么
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }

        char[] cs = str.toCharArray();

        System.arraycopy(value, pos, value, pos + cs.length, length - pos);
        System.arraycopy(cs, 0, value, pos, cs.length);

        length = length + cs.length;
    }

    public static void main(String[] args) {
        MyStringBuffer sb = new MyStringBuffer("There light");
        System.out.println(sb);

        try {
            sb.insert(-4, "let");
        } catch (Exception e) {
            System.out.println("异常具体原因" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("插入后");

        System.out.println(sb);

        try {
            sb.delete(0, 44);
        } catch (Exception e) {
            System.out.println("异常具体原因" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("删除后");
        System.out.println(sb);
    }

}
