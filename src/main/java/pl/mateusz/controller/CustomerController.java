package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.model.Customer;
import pl.mateusz.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/newCustomer")
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/create_customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/create_customer";
        } else  {
            customerService.saveCustomer(customer);
            return "redirect:/customers";
        }
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("id") long id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer/create_customer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/customer_list";
    }
}
