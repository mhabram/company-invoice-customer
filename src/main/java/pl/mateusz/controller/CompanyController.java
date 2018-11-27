package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.model.Company;
import pl.mateusz.service.CompanyService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/newCompany")
    public String newCompany(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "company/create_company";
    }

    @GetMapping("/companies")
    public String companies(Model model) {
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        return "company/company_list";
    }

    @PostMapping("/saveCompany")
    public String newCompany(@Valid @ModelAttribute("company") Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "company/create_company";
        } else {
            companyService.saveCompany(company);
            return "redirect:/companies";
        }
    }

    @GetMapping("/deleteCompany")
    public String deleteCompany(@RequestParam("id") long id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/updateCompany")
    public String updateCompany(@RequestParam("id") long id, Model model) {
        Company company = companyService.getCompany(id);
        model.addAttribute("company", company);
        return "company/create_company";
    }
}
