public class Global {
        /*
        需要使⽤对象.变量名才可以访问
        对象被实例化之后，实例变量的值就跟着确定，可以是赋值，也可以是默认值
        ⽣命周期在对象创建的时候创建，在对象被销毁的时候销毁
        访问修饰符可以修饰实例变量，⼀般是私有的，private修饰，然后通过⽅法来进⾏查看或者修改
         */
        //介绍前缀
        public String PREFIX ;
        public static final String ID = "1";

        //年龄
        private int age;

        //姓名
        private String name;

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
}

