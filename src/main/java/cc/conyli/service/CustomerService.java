package cc.conyli.service;

import cc.conyli.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(long customerId);

    void deleteCustomer(long customerId);
}
