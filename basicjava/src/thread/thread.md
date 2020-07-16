# 多线程

## 一、创建线程的方式
### 1、继承Thread，并重写run()方法
### 2、实现Runnable接口，并重写run()方法
### 3、匿名类实现方式

## 二、线程常用方法
### 1、暂停当前线程：Thread.sleep()
### 2、加入到当前线程：Thread.join()
### 3、设置线程优先级：
* Thread.setPriority(Thread.MAX_PRIORITY);
* Thread.setPriority(Thread.MIN_PRIORITY);
### 4、临时暂停线程：Thread.yield()
### 5、守护线程：Thread.setDaemon()

## 三、同步

## 四、线程安全的类
### 1、StringBuffer和StringBuilder
* StringBuffer：线程安全
* StringBuilder：非线程安全
### 2、ArrayList和Vector
* Vector：线程安全
* ArrayList：非线程安全
### 3、非线程安全转换为线程安全
* 使用Collections.synchronizedList

## 五、死锁（deadlock）

## 六、交互（deadlock）
### 1、wait()、notify()、notifyAll()
* wait()：让占用了这个同步对象的线程，临时释放当前占用，并等待。 在synchronized块里调用wait()，否则就会出错。
* notify()：通知一个等待在这个同步对象上的线程，有机会重新占用当前对象了。
* notifyAll()：通知所有的等待在这个同步对象上的线程，有机会重新占用当前对象了。
