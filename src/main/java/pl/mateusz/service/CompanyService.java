package pl.mateusz.service;

import pl.mateusz.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getCompanies();

    void deleteCompany(long id);

    void saveCompany(Company company);

    Company getCompany(long id);
}
