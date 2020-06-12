package Middle_Exception.GeneralExercise;

/**
 * @Author lee
 * @Date 2020/6/12 10:08 AM
 **/


public class OverDraftException extends Exception{
    public static double deficit;

    public OverDraftException(){

    }

    public OverDraftException(String msg){
        super(msg);
    }

    public OverDraftException(String msg, double deficit){

    }

    public static double getDeficit(){
        return deficit;
    }

}
