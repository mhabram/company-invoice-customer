package pl.mateusz.DAO;

import pl.mateusz.model.Invoice;

import java.util.List;

public interface InvoiceDAO {

    List<Invoice> getInvoices();

    void saveInvoice(Invoice invoice);

    void deleteInvoice(long id);

    Invoice getInvoice(long id);
}
