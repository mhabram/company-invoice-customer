package pl.mateusz.DAO;

import pl.mateusz.model.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void deleteCustomer(long id);

    void saveCustomer(Customer customer);

    Customer getCustomer(long id);
}
