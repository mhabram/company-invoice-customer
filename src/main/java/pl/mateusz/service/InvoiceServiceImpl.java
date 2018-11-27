package pl.mateusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.DAO.InvoiceDAO;
import pl.mateusz.model.Invoice;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceDAO invoiceDAO;

    @Autowired
    public InvoiceServiceImpl(InvoiceDAO invoiceDAO) {
        this.invoiceDAO = invoiceDAO;
    }

    @Override
    @Transactional
    public List<Invoice> getInvoices() {
        return invoiceDAO.getInvoices();
    }

    @Override
    @Transactional
    public void saveInvoice(Invoice invoice) {
        invoiceDAO.saveInvoice(invoice);
    }

    @Override
    @Transactional
    public void deleteInvoice(long id) {
        invoiceDAO.deleteInvoice(id);
    }

    @Override
    @Transactional
    public Invoice getInvoice(long id) {
        return invoiceDAO.getInvoice(id);
    }

}
