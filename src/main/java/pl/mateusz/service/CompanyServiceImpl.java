package pl.mateusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.DAO.CompanyDAO;
import pl.mateusz.model.Company;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    @Transactional
    public List<Company> getCompanies() {
        return companyDAO.getCompanies();
    }

    @Override
    @Transactional
    public void deleteCompany(long id) {
        companyDAO.deleteCompany(id);
    }

    @Override
    @Transactional
    public void saveCompany(Company company) {
        companyDAO.saveCompany(company);
    }

    @Override
    @Transactional
    public Company getCompany(long id) {
        return companyDAO.getCompany(id);
    }
}
