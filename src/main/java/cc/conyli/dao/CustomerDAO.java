package cc.conyli.dao;

import cc.conyli.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(long customerId);

    void deleteCustomer(long customerId);
}
