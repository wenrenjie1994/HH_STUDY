package CustomerSystem.service;

import CustomerSystem.bean.Customer;

/**
 * @Description CustomerList是Customer对象的管理模块
 *      内部管理一组Customer对象，提供相应的增删改查、遍历方法，并供CustomerView调用
 * @author
 * @version
 * @date 2020.7.18 11:05
 */

public class CustomerList {
    private Customer[] customers;
    private int total;

    //initialize Customer[] size
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        } else {
            customers[total++] = customer;
            return true;
        }
    }

    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            customers[index] = customer;
            return true;
        }
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i+1];
            }
            customers[--total] = null;
            return true;
        }
    }

    //get all customer information
    public Customer[] getAllCustomers() {
        Customer[] cu = new Customer[total];
        for (int i = 0; i < total; i++) {
            cu[i] = customers[i];
        }
        return cu;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        } else {
            return customers[index];
        }
    }

    public int getTotal() {
        return total;
    }
}
