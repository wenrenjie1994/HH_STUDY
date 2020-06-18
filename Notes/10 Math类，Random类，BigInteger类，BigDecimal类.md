## Math类
Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。
### 常用方法
* public static int abs(int a)
* public static double ceil(double a)
* public static double floor(double a)
* public static int max(int a,int b) //还有min
* public static double pow(double a,double b)
* public static double random() //生成0.0到1.0之间的所有小数,包括0.0,不包括1.0
* public static int round(float a) 
* public static double sqrt(double a)

## Random类
此类用于产生随机数。
如果用相同的种子创建两个 Random 实例，则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。
### 构造方法
* public Random()
* public Random(long seed)
### 成员方法
* public int nextInt()
* public int nextInt(int n) //生成在0到n范围内的随机数,包含0不包含n。常用。

## BigInteger类
可以让超过Integer范围内的数据进行运算
### 构造方法
* public BigInteger(String val)  //以字符串形式传入数字
### 成员方法
* public BigInteger add(BigInteger val)  //调用方法的对象的值不变，计算结果返回新的对象
* public BigInteger subtract(BigInteger val)
* public BigInteger multiply(BigInteger val)
* public BigInteger divide(BigInteger val)
* public BigInteger[] divideAndRemainder(BigInteger val)

## BigDecimal类
能精确的表示、计算浮点数
### 构造方法
* public BigDecimal(String val)  
	也可以用BigDecimal.valueOf(Double a) //这两种方式都能得到精确的传入数值
### 成员方法
* public BigDecimal add(BigDecimal augend)
* public BigDecimal subtract(BigDecimal subtrahend)
* public BigDecimal multiply(BigDecimal multiplicand)
* public BigDecimal divide(BigDecimal divisor)
