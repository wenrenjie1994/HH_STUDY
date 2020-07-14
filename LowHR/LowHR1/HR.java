package LowHR1;


class HR
{
	//这里修饰符用public合理吗？是否有更好的方式
	//	用private修饰符，并用get\set方法更好
	public String HRName;
	public String HRAuthor;
	public double HRPrice;
	
	public HR(String HRName,String HRAuthor,double HRPrice)
	{
		this.HRName=HRName;
		this.HRAuthor=HRAuthor;
		this.HRPrice=HRPrice;
	}
	
}
