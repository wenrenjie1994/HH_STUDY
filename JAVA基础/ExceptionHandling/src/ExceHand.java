public final class ExceHand{
	public static void main(String[] argc) {
		/*
		 int a[] = new int[2];
		try {
			System.out.println("Acess element three :"+ a[3]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown :"+ e);
		}
	    finally{
	        a[0] = 6;
	        System.out.println("First element value: " +a[0]);
	        System.out.println("The finally statement is executed");
	     }
	     */
		CheckingAccount c = new CheckingAccount(101);
	      System.out.println("Depositing $500...");
	      c.deposit(500.00);
	      try{
	         System.out.println("\nWithdrawing $100...");
	         c.withdraw(100.00);
	         System.out.println("\nWithdrawing $600...");
	         c.withdraw(600.00);
	      }catch(InsufficientFundsException e){
	         System.out.println("Sorry, but you are short $" + e.getAmount());
	         e.printStackTrace();
	      }
	}
}

//自定义异常类，继承Exception类
private class InsufficientFundsException extends Exception{
	private double amount;
	public InsufficientFundsException(double amount){
	  this.amount = amount;
	} 
	public double getAmount(){
	  return amount;
	}
}
//此类模拟银行账户
private class CheckingAccount
{
	//balance为余额，number为卡号
	 private double balance;
	 private int number;
	 public CheckingAccount(int number){
	    this.number = number;
	 }
	//方法：存钱
	 public void deposit(double amount){
	    balance += amount;
	 }
	//方法：取钱
	 public void withdraw(double amount) throws
	                            InsufficientFundsException {
	    if(amount <= balance){
	       balance -= amount;
	    }
	    else{
	       double needs = amount - balance;
	       throw new InsufficientFundsException(needs);
	    }
	 }
	//方法：返回余额
	 public double getBalance(){
	    return balance;
	 }
	//方法：返回卡号
	 public int getNumber(){
	    return number;
	 }
}