
//switch 穿透
public class Demo04SwitchNotice{
	public static void main(String args[]){
		int a = 0;
		switch(a){
			default:
				break;
			case 0:
				System.out.println("我是0");
				break;
			case 10:
				System.out.println("我是10");
				//break;
			case 20:
				System.out.println("我是20");
				break;
		}
	}
}
