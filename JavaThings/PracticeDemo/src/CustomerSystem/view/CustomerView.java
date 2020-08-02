package CustomerSystem.view;

import CustomerSystem.CMUtility;
import CustomerSystem.service.CustomerList;
import CustomerSystem.bean.Customer;

/**
 * @Description 主模块，负责菜单的显示和处理用户操作
 * @author
 * @version
 * @date 2020.7.18 11:07
 */

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    //display frame
    public void enterMainMenu() {
        boolean flag = true;

        while (flag) {
            System.out.println("\n----------Customer information management software----------");
            System.out.println("            1.add customer");
            System.out.println("            2.modify info");
            System.out.println("            3.delete customer");
            System.out.println("            4.list all customers");
            System.out.println("            5.   exit");
            System.out.print("please input 1-5: ");

            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("Do you want to exit(Y/N): ");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                    }
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("***** add customer *****");

        System.out.print("name: ");
        String name = CMUtility.readString(20);
        System.out.print("gender: ");
        char gender = CMUtility.readChar('m');
        System.out.print("age: ");
        int age = CMUtility.readInt();
        System.out.print("phone: ");
        String phone = CMUtility.readString(13);
        System.out.print("email: ");
        String email = CMUtility.readString(20);

        //encapsulation
        /*
        Customer customer = new Customer("PlusTorking", 'm',
                23, "18990092988", "hao@163.com");
                */
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("add success!!");
        } else {
            System.out.println("add false, please check again!!");
        }

        System.out.println("***** add customer *****");
    }

    private void modifyCustomer() {
        System.out.println("****** modify customer *******");

        Customer customer;
        int num;
        while (true) {
            System.out.print("select id(-1 is exit): ");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }
            customer = customerList.getCustomer(num-1);
            if (customer == null) {
                System.out.println("can't find the customer!!");
            } else {
                break;
            }
        }

        //modify information
        System.out.println("name(" + customer.getName() + ")");
        System.out.println("gender(" + customer.getGender() + ")");
        System.out.print("age(" + customer.getAge() + "): ");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("phone(" + customer.getPhone() + "): ");
        String phone = CMUtility.readString(13, customer.getPhone());
        System.out.print("email(" + customer.getEmail() + "): ");
        String email = CMUtility.readString(13, customer.getEmail());

        Customer customerTemp = new Customer(customer.getName(), customer.getGender(), age, phone, email);
        if (customerList.replaceCustomer(num-1, customerTemp)) {
            System.out.println("modify is succeed!!!");
        } else {
            System.out.println("modify is false!!");
        }

    }

    private void deleteCustomer() {
        System.out.println("********** delete customer **********");

        int num;
        while (true) {
            System.out.println("please select customer id(-1 is exit): ");
            num = CMUtility.readInt();

            if (num == -1) {
                return;
            }
            Customer customer = customerList.getCustomer(num - 1);
            if (customer == null) {
                System.out.println("can't find the customer!!");
            } else {
                break;
            }
        }

        //find the customer
        System.out.println("Are you sure to delete(Y/N): ");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            customerList.deleteCustomer(num - 1);
            System.out.println("********* delete succeed **********");
        }
    }

    private void listAllCustomer() {
        System.out.println("******** customer table ********");

        int num = customerList.getTotal();
        if (num == 0) {
            System.out.println("It's empty!!!");
        } else {
            System.out.println("id\t\tname\t\tgender\tage\tphone\t\temail");
            Customer[] customers = customerList.getAllCustomers();
            for (int i = 0; i < customers.length; i++) {
                Customer customer = customers[i];
                System.out.println((i+1) + "\t\t" + customer.getName() + "\t\t" +
                        customer.getGender() + '\t' + customer.getAge() + '\t' +
                        customer.getPhone() + "\t\t" + customer.getEmail());
            }
        }

        System.out.println("******** customer table ********");
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();

        customerView.enterMainMenu();
    }
}
