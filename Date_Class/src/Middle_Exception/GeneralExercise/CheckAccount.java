package Middle_Exception.GeneralExercise;

/**
 * @Author lee
 * @Date 2020/6/12 10:24 AM
 **/


public class CheckAccount extends Account {
    private static double overdraftProtect;//允许透支的额度

    public CheckAccount() {

    }

    public CheckAccount(double balance) {
        super(balance);
    }

    public void deposit(double atm) {
        super.deposit(atm);
    }

    public void showBalance() {

    }

    public void withdraw(double atm) throws OverDraftException {
        // 1.取出未超过账户余额
        if (atm <= balance) {
            balance -= atm;
            System.out.println("取钱成功！取出"+atm+"元！账户余额为："+balance+"元！透支额度为："+overdraftProtect+"元！");
            //这里需要返回，因为这个操作结束了，不需要进行后续操作了。并列的if else就不需要return,如果都是if if if则不需要返回空
        }
        // 2.取出后超过账户余额，但未超过透支额度
        else if (atm > balance && atm <= (balance + overdraftProtect)) {
            overdraftProtect -= (atm-balance);
            System.out.println("取钱成功！取出"+atm+"元！账户余额为：0"+"元！透支额度为："+overdraftProtect+"元！");

        }
        // 3.取出后超过账户余额也超过了透支额度
        else if (atm > (balance + overdraftProtect)) {
            throw new OverDraftException("透支超额，超出："+(atm - (balance + overdraftProtect))+"元");
        }

    }

    public static void main(String[] args) {
        CheckAccount ca = new CheckAccount(5000);
        overdraftProtect = 3000;

        ca.deposit(5000);

        try{
            ca.withdraw(3000);
            ca.withdraw(3000);
            ca.withdraw(3000);
            ca.withdraw(3000);
            ca.withdraw(3000);
        }catch (OverDraftException e){
            e.printStackTrace();
        }

    }
}
