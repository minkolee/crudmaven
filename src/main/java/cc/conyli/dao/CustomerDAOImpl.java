package cc.conyli.dao;

import cc.conyli.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //构造器方法注入
    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Customer> getCustomers() {
        System.out.println("从数据库中查找多个");
        //获取Customers查询结果
        Session session = sessionFactory.getCurrentSession();
        //用原始的方法查询
        return session.createQuery("From Customer customer ORDER BY customer.id", Customer.class).getResultList();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        return customer;
    }

    @Override
    public Customer getCustomer(long customerId) {
        System.out.println("从数据库中查找单个");
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(long customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        session.delete(customer);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
