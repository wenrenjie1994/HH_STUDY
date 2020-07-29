package demo03;
/*局部内部类如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final】
* 备注：从java8开始，只要局部变量事实不变，那么final关键字省略
* 原因：
* 1.new出来的对象在堆内存中
* 2.局部变量跟着方法走，在栈内存中
* 3.方法运行结束后，立刻出栈，局部变量就会立刻消失
* 4.但是new出来的对象会在堆中持续存在，直到垃圾回收消失
* 总结：运行周期不同所造成的。
* */
public class MyOuter {
    public void methodOuter(){
        int num=10;
        //num 改变了，则内部类中访问num会出错
        //num=20;
        class MyInner{
            public void methodInner(){
                System.out.println(num);
            }
        }
    }
}