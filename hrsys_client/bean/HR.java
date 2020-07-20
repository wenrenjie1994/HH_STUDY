package bean;


class HR
{
	//这里修饰符用public合理吗？是否有更好的方式
	//用private修饰符，并用get\set方法更好
	//权限范围 public>protect>默认包权限>private
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
