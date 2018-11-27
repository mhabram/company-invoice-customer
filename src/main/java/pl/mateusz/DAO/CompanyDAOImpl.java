package pl.mateusz.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mateusz.model.Company;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CompanyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Company> getCompanies() {
        Session session = sessionFactory.getCurrentSession();
        Query<Company> query = session.createQuery("FROM Company", Company.class);
        List<Company> company = query.getResultList();
        return company;
    }

    @Override
    public void deleteCompany(long id) {
        Session session = sessionFactory.getCurrentSession();
        Company company = session.get(Company.class, id);

        boolean isTrue = company.getInvoices().isEmpty();

        System.out.println(isTrue);

        if (isTrue) {
            session.delete(company);
        } else  {
            System.out.println("Company is associated with invoice.");
        }
    }

    @Override
    public void saveCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();

        boolean isTrue = session.createQuery("FROM Company c " +
                "WHERE c.vatID =" + company.getVatID())
                .setMaxResults(1)
                .uniqueResult() != null;

        if (!isTrue) {
            session.saveOrUpdate(company);
        } else  {
            session.merge(company);
            System.out.println("Firma z takim NIP juz istnieje.");
        }
    }

    @Override
    public Company getCompany(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }
}
