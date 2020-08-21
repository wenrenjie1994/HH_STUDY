**Properties集合笔记**  

----------


**一、使用Properties集合存储数据，遍历**  
java.util.Properties集合 extends Hashtable<k, v> implements Map<k, v>  
Properties类表示了一个持久的属性集，Properties可保存在流中或从流中加载，属性列表中每个键及其对应值都是一个字符串  
Properties集合是唯一一个和IO流相结合的集合  
可以使用Properties集合中的方法store把集合中的临时数据，持久化写入到硬盘中存储  
可以使用Properties集合中的方法load把硬盘中保存的文件（键值对），读取到集合中使用  
Properties集合是一个双列集合，key和value默认都是字符串  
Properties集合有一些操作字符串的特有方法  

    Object setProperty(String key, String value)：调用Hashtable的方法put
    
    Object getProperty(String key)：通过key获取value，此方法相当于Map集合中的get(key)方法
    
    Set<String> stringPropertyNames()：返回此属性列表中的键集，其中该键及其对应值是字符串，此方法相当于Map集合中的keySet方法

**二、Properties集合中的方法store**  
void store(OutputStream out, String comments)  
void store(Writer writer, String comments)  
参数：  
OutputStream out：字节输出流，不能写入中文  
Writer writer：字符输出流，可以写入中文  
String comments：注释，用来解释说明保存的文件是做什么用的；不能使用中文，会产生乱码，因为默认是Unicode编码；一般使用""空字符串    

使用步骤：  
1.创建一个Properties集合对象，添加数据  
2.创建字节输出流/字符输出流，构造方法中绑定要输出的目的地  
3.使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储  
4.释放资源  

**三、Properties集合中的方法load**  
void load(InputStream inStream)  
void load(Reader reader)  
参数：  
InputStream inStream：字节输入流，不能读取含有中文的键值对  
Reader reader：字符输入流，能读取含有中文的键值对  

使用步骤：  
1.创建一个Properties集合对象  
2.使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用  
3.遍历Properties集合  

注意事项：  
1.存储键值对的文件中，键与值默认的连接符号可以使用=、空格、...  
2.存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取  
3.存储键值对的文件中，键与值默认的都是字符串，不用再加引号  