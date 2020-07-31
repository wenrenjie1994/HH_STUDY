package Example01;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        //a new customer
        bank.addCustomer("Hao", "Torking");

        //initialize a customer's account
        bank.getCustomer(0).setAccount(new Account(8000));

        //withdraw
        double money = bank.getCustomer(0).getAccount().withdraw(1000);

        //check the balance
        double balance = bank.getCustomer(0).getAccount().getBalance();
        System.out.println("YU E: " + balance);

        bank.addCustomer("Liu", "Accepted");
        System.out.println(bank.getNumberOfCustomer());
    }
}
