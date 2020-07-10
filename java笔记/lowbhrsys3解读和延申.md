# lowbhrsys3

lowbhrsys3学习过程，简单解读下代码并相应延伸.按照包和类分。

## bean

书本bean：

```java
	public String bookName;//书名
	
	public String bookAuthor;//作者
	
	public double bookPrice;//价格
//alt+insert：自动生成构造函数、getset函数
```

### LinkedList

bean中还包含一个书链表：空类继承了LinkedList<Book>

==LinkedList本质是双向链表==

```java
//LinkedList：继承自虚顺序链表（包含add、get、set、remove等链表基础操作）。实现了链表、双向队列、cloneable、可序列化接口。
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable{
    transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    transient Node<E> last;
    
    //结点部分：包含两端的指针和本身。所以本质是双向链表
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
```

LinkedList部分方法：

- add（E e）、add（index，element）：添加一个元素，默认是添加到末尾，可以指定。addAll（）、addFirst（）、addLast（）：字面用法
- clear：删除所有元素。
- contains（Object o）：查找是否包含，返回boolean
- element（）：返回队头元素，不删除。（就是直接使用getFirst函数）peek（）：一样的，只是会检查是否为空。为空则返回null，而element则会抛出没有元素的异常。
- get（index）、getFirst（）、getLast（）：字面用法。
- indexOf（object o）：返回指定元素第一次出现的位置，如果没有返回-1。lastIndexOf（）：字面意思。
- offer（E e）：添加元素到列表的尾部。（就是直接用的add函数）offerFirst（）、offerLast（）：字面意思。
- remove（）：移除。可以带元素（表示删除第一个出现的位置）、下标（删除下标位置的元素）。
- toArray（）：按顺序返回数组。

## database

数据库项目使用的是JDK中包含的java.sql包来进行连接：

```java
static final String url = "jdbc:mysql://127.0.0.1:3306/bookmis";
	    static final String name = "com.mysql.jdbc.Driver";  
	    static final String user = "root";  
	    static final String password = "12345678";
	    Connection con = null; 
	    Statement statement= null;
	    
//检查连接
		static
		{
			try
				{
                //查找类来进行检查
				 Class.forName(name);//指定连接类型  
				}
			catch(ClassNotFoundException cE)
				{
					System.out.println("Class Not Found Exception:"+cE.toString());
				}
		}
//连接核心
		public static Connection getConnection()
		{
			try {
				return DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
```

DriverManager.getConnection(url,user,password)：方法

```java
//装配类，用于将参数放入Properties中。然后调用getConnection方法获取。
@CallerSensitive
    public static Connection getConnection(String url,
        String user, String password) throws SQLException {
        java.util.Properties info = new java.util.Properties();

        if (user != null) {
            info.put("user", user);
        }
        if (password != null) {
            info.put("password", password);
        }
//这里是多态的调用另一个核心方法
        return (getConnection(url, info, Reflection.getCallerClass()));
    }
//核心类：
private static Connection getConnection(
        String url, java.util.Properties info, Class<?> caller) throws SQLException {
        
        ClassLoader callerCL = caller != null ? caller.getClassLoader() : null;
    //悲观锁类型，直接对整个类进行加锁。
        synchronized(DriverManager.class) {
            // synchronize loading of the correct classloader.
            if (callerCL == null) {
                callerCL = Thread.currentThread().getContextClassLoader();
            }
        }
        if(url == null) {
            throw new SQLException("The url cannot be null", "08001");
        }
        println("DriverManager.getConnection(\"" + url + "\")");
        SQLException reason = null;
    //迭代加载所有注册了的连接，用于检查是否是合法的连接。这部分后面可以再看看
        for(DriverInfo aDriver : registeredDrivers) {
            //如果是注册了的合法连接，则开始建立连接。
            if(isDriverAllowed(aDriver.driver, callerCL)) {
                try {
                    println("    trying " + aDriver.driver.getClass().getName());
                    //进行连接
                    Connection con = aDriver.driver.connect(url, info);
                    if (con != null) {
                        // Success!
                        println("getConnection returning " + aDriver.driver.getClass().getName());
                        return (con);
                    }
                } catch (SQLException ex) {
                    if (reason == null) {
                        reason = ex;
                    }
                }

            } else {
                println("    skipping: " + aDriver.getClass().getName());
            }

        }

        // if we got here nobody could connect.
        if (reason != null)    {
            println("getConnection failed: " + reason);
            throw reason;
        }

        println("getConnection: no suitable driver found for "+ url);
        throw new SQLException("No suitable driver found for "+ url, "08001");
    }
```

## library06

这部分是控制台打印输入输出部分。

## work

service层部分：

```java
//添加图书方法。
	public int addbook(Book book)
	{ 
		int line = 0;
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			//拼接的sql，使用的是statement不能防止SQL注入。改用prepared statement或者进行参数过滤检查。
            String stringSql = "insert into bookmis values('"+book.bookName+"','"+book.bookAuthor+"','"+book.bookPrice+"')";
			line=statement.executeUpdate(stringSql);
            //优化：不用每次建立连接和关闭连接，客户端账户登入后维护一个时间戳，超时或者用户推出自动断开连接。
			DBConnection.closeConnection(null,statement,conn);	
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return line;
	}
```

## 其他：

@CallerSensitive：这个注解是为了堵住漏洞用的。曾经有黑客通过构造双重反射来提升权限，原理是当时反射只检查固定深度的调用者的类，
看它有没有特权，例如固定看两层的调用者（getCallerClass(2)）。如果我的类本来没足够权限群访问某些信息，
那我就可以通过双重反射去达到目的：反射相关的类是有很高权限的，而在 我->反射1->反射2这样的调用链上， 反射2检查权限时看到的是反射1的类，这就被欺骗了，导致安全漏洞。使用CallerSensitive后，getCallerClass不再用固定深度去寻找actual caller（“我”），而是把所有跟反射相关的接口方法都标注上CallerSensitive，搜索时凡看到该注解都直接跳过，这样就有效解决了前面举例的问题。

下面是我的理解：
字面理解：调用敏感检查。也就是防止通过反射去获取不应该有的权限，添加这个注解后会对调用中的反射进行检查，比如：我反射得到1，1反射得到2。然后2进行检查1有@CallerSensitive，那么就跳过不算，由于存在固定检查深度，所以会进而检查到我，我就无法通过多重反射去获取不对应的权限了。