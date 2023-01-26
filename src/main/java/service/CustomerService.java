package service;

import dao.CustomerDaoImpl;
import model.Customer;

import java.sql.Connection;
import java.util.List;

public class CustomerService {
    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    public List<Customer> getAllCustomers(){
        return customerDao.getAll();
    }

    public Customer getCustomerById(int id){
        return customerDao.getEntityById(id);
    }

    public void updateCustomer(Customer customer){
        customerDao.update(customer);
    }

    public void saveCustomer(Customer customer){
        customerDao.save(customer);
    }

    public void deleteCustomer(Customer customer){
        customerDao.delete(customer.getCustomerId());
    }
}
