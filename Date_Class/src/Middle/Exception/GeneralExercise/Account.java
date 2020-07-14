package Middle_Exception.GeneralExercise;

/**
 * @Author lee
 * @Date 2020/6/12 10:12 AM
 **/


public class Account {
    public static double balance;
    double deficit;

    public Account() {

    }

    public Account(double balance) {
        Account.balance = balance;
        if (balance < 0) {
            System.out.println("存入不能为负，请重新输入");
            return;
        }
        System.out.println("账户初始存入" + balance + "元");
    }

    public void showBalance() {
        System.out.println("查看余额为:" + balance);

    }

    public void deposit(double atm) {
        balance += atm;
        System.out.println("存入" + atm + "元");
        System.out.println("账户余额为：" + balance + "元");
    }

    public void withdraw(double atm) throws OverDraftException {
        balance -= atm;
        if (balance < 0) {
            throw new OverDraftException("余额不足，透支余额为：" + (atm - balance));
        } else {
            System.out.println("取钱成功：" + atm + "元！剩余：" + balance + "元");
        }
    }

    public static void main(String[] args) {
        Account a = new Account(4000);
        a.deposit(1000);
        try {
            a.withdraw(2000);
            a.showBalance();
        } catch (OverDraftException e) {
            e.printStackTrace();

        }
    }

}
