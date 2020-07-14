package Middle_Exception.Category;

/**
 * @Author lee
 * @Date 2020/6/12 7:31 AM
 *
 * 书籍：《Java程序员面试笔试宝典》
 **/


public class Exercise_my {
    /**
     * 运行时异常 RuntimeException，能否被捕捉？
     *      Java编译要求方法中必须声明可能发生的非运行时异常（可查异常CheckedException）
     *
     * Throwable是所有Java程序异常处理的基类，其子类有：Exception和Error
     *      Error不可能捕捉，属于JVM层次的错误，最多显示错误信息，如内存用光OutOfMemoryError
     *      Exception是可以捕捉的
     *          CheckedException，必须要处理
     *          RuntimeException，可以不处理，由JVM接管，也可以被catch
     *          如果不处理RuntimeException异常，出现这些异常时，要么线程被终止，要么主程序终止
     *
    * */
}
