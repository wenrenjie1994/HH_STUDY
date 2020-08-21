**Random对象**  

----------

**一、Random概述和基本使用**  
1.Random类用来生成随机数字  
2.获取一个随机的int数字（范围是int所有范围，有正负两种）：Random类实例对象.nextInt()  

**二、Random生成指定范围的随机数**  
获取一个随机的int数字（参数代表了范围，左闭右开区间）：Random类实例对象.nextInt(3)；实际上代表的含义是：[0,3)，也就是0~2  

**三、Random练习一_生成1-n之间的随机整数[1-n]**  

    Random r = new Random();  
    int result = r.nextInt(n) + 1;  

**四、Random练习二_猜数字小游戏**  