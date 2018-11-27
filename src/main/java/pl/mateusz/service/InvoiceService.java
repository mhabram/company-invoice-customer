package pl.mateusz.service;

import pl.mateusz.model.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getInvoices();

    void saveInvoice(Invoice invoice);

    void deleteInvoice(long id);

    Invoice getInvoice(long id);
}
