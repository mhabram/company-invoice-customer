package pl.mateusz.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mateusz.model.Company;
import pl.mateusz.model.Customer;
import pl.mateusz.model.Invoice;

import java.util.List;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public InvoiceDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Invoice> getInvoices() {
        Session session = sessionFactory.getCurrentSession();
        Query<Invoice> query = session.createQuery("FROM Invoice", Invoice.class);
        return query.getResultList();
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        Session session = sessionFactory.getCurrentSession();

        Query<Company> companyId = session.createQuery("FROM Company c " +
                "WHERE c.vatID ="+invoice.getCompany().getVatID(), Company.class);
        Query<Customer> customerId = session.createQuery("FROM Customer c " +
                "WHERE c.peselId ="+invoice.getCustomer().getPeselId(), Customer.class);

        boolean isTrueCompany = companyId.getResultList().isEmpty();
        boolean isTrueCustomer = customerId.getResultList().isEmpty();

        if (!isTrueCompany) {
            Company company = session.get(Company.class, companyId.getSingleResult().getId());
            invoice.setCompany(company);
        }
        if (!isTrueCustomer) {
            Customer customer = session.get(Customer.class, customerId.getSingleResult().getId());
            invoice.setCustomer(customer);
        }

        if (!isTrueCompany && !isTrueCustomer) {
            session.saveOrUpdate(invoice);
        } else  {
            System.out.println("There is no customer or company with that VatID / PeselID");
        }
    }

    @Override
    public void deleteInvoice(long id) {
        Session session = sessionFactory.getCurrentSession();
        Invoice invoice = session.get(Invoice.class, id);

        if (invoice != null) {
            session.delete(invoice);
        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Override
    public Invoice getInvoice(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Invoice.class, id);
    }
}
