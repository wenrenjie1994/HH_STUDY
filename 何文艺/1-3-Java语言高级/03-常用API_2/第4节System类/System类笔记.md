**System类笔记**  

----------


System类的常用用法：java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作  
1.static long currentTimeMillis():返回当前时间（以毫秒为单位）  
作用：用来测试程序的效率（在程序执行前和执行后分别获取毫秒值，取差值即能得到程序运行时间）  

2.static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length):将指定源数组中的数组从指定位置复制到目标数组的指定位置  

    参数：
    src         -源数组
    srcPos      -源数组中的起始位置（起始索引）
    dest        -目标数组
    destPos     -目标数组中的起始位置（起始索引）
    length      -要复制的数组元素的长度