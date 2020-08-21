**File类笔记**  

------

**一、File类的概述**  
java.io.File类是文件和目录（文件夹）路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作  
java把电脑中的文件和目录封装为了一个File类，我们可以使用File类对文件和目录进行操作  

Flie类的功能：  

1.创建文件/文件夹  
2.删除文件/文件夹  
3.获取文件/文件夹  
4.判断文件/文件夹是否存在  
5.对文件夹进行遍历  
6.获取文件的大小  

File类是一个与系统无关的类，任何的操作系统都可以使用这个类中的方法  
file：文件  
directory：文件夹/目录  
path：路径  

**二、File类的静态成员变量**  

    1. static String pathSeparator：与系统有关的路径分隔符，为了方便，它被表示为一个字符串
    
    2. static char pathSeparatorChar ：与系统有关的路径分隔符
       路径分隔符：windows是分号;  linux是冒号:
       
    3. static String separator：与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串
    
    4. static char separatorChar：与系统有关的默认名称分隔符
       文件名称分隔符：windows是反斜杠\；linux是正斜杠/
       操作路径：路径不能写死了

**三、绝对路径和相对路径**  

1.绝对路径：是一个完整的路径；以盘符开始的路径  
2.相对路径：是一个简化的路径；相对指的是【相对于当前项目的根目录】；如果使用当前项目的根目录，路径可以简化书写  

注意：  
a.路径是不区分大小写的  
b.路径中的文件名称分隔符，windows使用反斜杠\，反斜杠是转义字符，两个反斜杠\\代表一个普通的反斜杠\  

**四、File类的构造方法**  

    1.File(File parent, String child)：从父抽象路径名和子路径名字符串创建新的File实例  
        参数：把路径分成了两部分父路径File parent和子路径String child  
        好处：父路径和子路径，可以单独书写，使用起来非常灵活；父路径和子路径都可以变化  
        父路径是File类型，可以使用File类的方法对路径进行一些操作，再使用路径创建对象  
        
    2.File(String pathName)：通过将给定的路径名字符串转换为抽象路径名来创建新的File实例  
        参数String pathName：字符串的路径名称  
        路径可以是以文件结尾，也可以是以文件夹结尾  
        路径可以是相对路径，也可以是绝对路径  
        路径可以是存在的，也可以是不存在的  
        创建File对象只是把字符串的路径封装为File对象，不考虑路径的真假  
        
    3.File(String parent, String child)：从父路径名字符串和子路径名字符串创建新的File实例  
        参数：把路径分成了两部分父路径String parent和子路径String child  
        父路径和子路径单独书写，使用起来非常灵活；父路径和子路径都可以变化  

**五、File类获取功能的方法**  

    1.public String getAbsolutePath()：返回此File的绝对路径名字符串
        获取构造方法中传递的路径
        无论路径是绝对的还是相对的，getAbsolutePath()方法返回的都是绝对路径
    
    2.public String getPath()：将此File转换为路径名字符串
        获取构造方法中传递的路径
        toString方法调用的就是getPath方法
        源码：
        public String toString() {
           return getPath();
        }
    
    3.public String getName()：返回由此File表示的文件或目录的名称
        获取构造方法传递路径的结尾部分（文件/文件夹）
    
    4.public long length()：返回由此File表示的文件的长度
        获取构造方法指定的文件的大小，以字节为单位
        注意：文件夹是没有大小概念的，不能获取文件夹的大小
        如果构造方法中给出的路径不存在，那么length方法返回0

**六、File类判断功能的方法**  

    1.public boolean exists()：此File表示的文件或目录（文件或文件夹）是否实际存在
        用于判断构造方法中的路径是否存在
    
    2.public boolean isDirectory()：此File表示的是否为目录（以文件夹结尾）
        用于判断构造方法中的路径是否以文件夹结尾
    
    3.public boolean isFile()：此File表示的是否为文件（以文件结尾）
        用于判断构造方法中的路径是否以文件结尾
        注意：
            a.电脑的硬盘中只有文件/文件夹，两个方法是互斥的
            b.这两个方法使用前提：路径必须是存在的，否则都返回false

**七、File类创建删除功能的方法**  

    1.public boolean createNewFile()：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
    注意：
    a.此方法只能创建文件，不能创建文件夹
    b.创建文件的路径必须存在，否则会抛出异常
    
    2.public boolean delete()：删除由此File表示的文件或目录
    注意：delete方法是直接在硬盘删除文件/文件夹，不走回收站，删除要谨慎
    
    3.public boolean mkdir()：创建由此File表示的目录（创建单级空文件夹）
    4.public boolean mkdirs()：创建由此File表示的目录，包括任何必须但不存在的目录（创建单级空文件夹和多级文件夹）
    注意：这两个方法只能创建文件夹，不能创建文件

**八、File类遍历（文件夹）目录的方法**  

    1.public String[] list()：返回一个String数组，表示该File目录中的所有子文件或目录
    
    2.public File[] listFiles()：返回一个File数组，表示该File目录中的所有子文件或目录
    注意：
    a.list方法和listFiles方法遍历的是构造方法中给出的目录
    b.如果构造方法中给出的目录的路径不存在，会抛出空指针异常
    c.如果构造方法中给出的路径不是一个目录，也会抛出空指针异常