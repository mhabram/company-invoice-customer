package pl.mateusz.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mateusz.model.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
        List<Customer> customer = query.getResultList();
        return customer;
    }

    @Override
    public void deleteCustomer(long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);

        boolean isTrue = customer.getInvoices().isEmpty();

        if (isTrue) {
            session.delete(customer);
        } else {
            System.out.println("Customer is associated with invoice.");
        }

    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        boolean isTrue = session.createQuery("FROM Customer c " +
                "WHERE c.peselId=" + customer.getPeselId())
                .setMaxResults(1)
                .uniqueResult() != null;

        if (!isTrue) {
            session.saveOrUpdate(customer);
        } else  {
            session.merge(customer);
            System.out.println("Uzytkownik z takim PESELem juz isntieje");
        }

    }

    @Override
    public Customer getCustomer(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }
}
