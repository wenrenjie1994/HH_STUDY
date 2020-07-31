package Example01;

public class Account {
    private double balance;

    public Account(double balance) {        //ctor
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("deposit succeed!!");
        }
    }
    public double withdraw(double amt) {
        if (amt > balance) {
            balance = 0;
            System.out.println("balance is not enough!!");
            return balance;
        } else {
            balance -= amt;
            System.out.println("withdraw is succeed!!");
            return amt;
        }
    }
}
