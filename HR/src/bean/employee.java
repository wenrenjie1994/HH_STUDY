package bean;


public class employee
{
	//这里修饰符用public合理吗？是否有更好的方式
	public String Name;
	public int Age;
	public int Num;//工号
	
	public employee(String Name,int Age,int Num)
	{
		this.Name=Name;
		this.Age=Age;
		this.Num=Num;
	}
	
}
