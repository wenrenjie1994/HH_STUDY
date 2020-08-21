**Calendar类笔记**  

----------


**一、Calendar类介绍_获取对象的方式**  
java.util.Calendar类：日历类  
Calendar类是一个抽象类，里面提供了很多操作日历字段的方法（YEAR、MONTH、DAY_OF_MONTH、HOUR等等）  
Calendar类无法直接创建对象使用，里面有一个静态方法叫Calendar.getInstance()，该方法返回了Calendar类的子类对象  
static Calendar getInstance()：使用默认时区和语言环境设获取日历  

**二、Calendar类的常用成员方法**  
1.public int get(int field)：返回给定日历字段的值  
2.public void set(int field, int value)：将给定的日历字段设置为给定的值  
3.public abstract void add(int field, int   amount):根据日历的规则，为给定的日历字段添加或减去指定的时间量  
4.public Date getTime():返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象  

成员方法的参数：  
1.int field：日历类的字段，可以使用Calendar类的静态成员变量获取  

    public final static int YEAR = 1;           年
    public final static int MONTH = 2;          月
    public final static int DATE = 5;           日
    public final static int DAY_OF_MONTH = 5;   日
    public final static int HOUR = 10;          时
    public final static int MINUTE = 12;        分
    public final static int SECOND = 13;        秒

2.int amount：增加或减少指定的值（正数增加，负数减少）  