package pl.mateusz.DAO;

import pl.mateusz.model.Company;

import java.util.List;

public interface CompanyDAO {

    List<Company> getCompanies();

    void deleteCompany(long id);

    void saveCompany(Company company);

    Company getCompany(long id);
}
