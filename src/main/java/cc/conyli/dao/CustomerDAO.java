package cc.conyli.dao;

import cc.conyli.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);
}
