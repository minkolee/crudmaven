package cc.conyli.service;

import cc.conyli.dao.CustomerDAO;
import cc.conyli.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@CacheConfig(cacheNames = "users")
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    @Cacheable(key = "'list'")
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    @Caching(put = @CachePut(key = "#customer.id"), evict = @CacheEvict(key = "'list'"))
    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    @Cacheable
    public Customer getCustomer(long customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Override
    @Transactional
    @Caching(evict = @CacheEvict(key = "'list'"))
    public void deleteCustomer(long customerId) {
        customerDAO.deleteCustomer(customerId);
    }
}
