package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.model.Invoice;
import pl.mateusz.service.InvoiceService;
import pl.mateusz.utilities.InvoiceUtilities;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/newInvoice")
    public String newInvoice(Model model) {
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "invoice/create_invoice";
    }

    @GetMapping("/invoiceList")
    public String invoiceList(Model model) {
        List<Invoice> invoices = invoiceService.getInvoices();
        model.addAttribute("invoices", invoices);
        return "invoice/invoice_list";
    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(@Valid @ModelAttribute Invoice invoice, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "invoice/create_invoice";
        } else  {
            invoiceService.saveInvoice(invoice);
            return "redirect:/invoiceList";
        }
    }

    @GetMapping("/updateInvoice")
    public String updateInvoice(@RequestParam("id") long id, Model model) {
        Invoice invoice = invoiceService.getInvoice(id);
        model.addAttribute("invoice", invoice);
        return "invoice/create_invoice";
    }

    @GetMapping("/deleteInvoice")
    public String deleteInvoice(@RequestParam("id") long id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/invoiceList";
    }

    @GetMapping("/invoice")
    public String customer(@RequestParam("id") long id, Model model) {
        Invoice invoice = invoiceService.getInvoice(id);
        InvoiceUtilities invoiceUtilities = new InvoiceUtilities();

        float nettoAmount = invoiceUtilities.nettoAmount(invoice.getNetValue(), invoice.getQuantity());
        String vatTax = invoiceUtilities.vatTax(nettoAmount, invoice.getTaxRate());
        String grossValue = invoiceUtilities.grossValue(invoice.getNetValue(), invoice.getQuantity(), invoice.getTaxRate());

        String inWorlds = invoiceUtilities.numberInWorlds(invoice.getNetValue(), invoice.getQuantity(), invoice.getTaxRate());

        model.addAttribute("invoice", invoice);
        model.addAttribute("nettoAmount", nettoAmount);
        model.addAttribute("vatTax", vatTax);
        model.addAttribute("grossValue", grossValue);
        model.addAttribute("inWorlds", inWorlds);
        return "invoice/invoice";
    }
}
