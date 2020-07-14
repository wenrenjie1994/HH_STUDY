package Middle_Exception.SelfDefineException;

/**
 * @Author lee
 * @Date 2020/6/12 8:02 AM
 * 自定义一个异常，继承Exception类，那这不属于错误了。
 **/


public class CreateSelfDefineException extends Exception{
    //提供了两个构造方法
    public CreateSelfDefineException(){

    }
    public CreateSelfDefineException(String str){
        super(str);
    }
    
}
