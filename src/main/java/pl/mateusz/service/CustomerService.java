package pl.mateusz.service;

import pl.mateusz.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void deleteCustomer(long id);

    void saveCustomer(Customer customer);

    Customer getCustomer(long id);
}
