
package appGr.dao;

import appGr.dao.repositories.InvoiceRepository;
import appgr.dao.interfaces.InvoiceDao;
import appgr.model.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class Invoicedaoimlementation implements InvoiceDao {
     @Autowired
    InvoiceRepository invoiceRepository;
    public void createInvoice(Invoice invoice) throws Exception{
        invoiceRepository.save(invoice);
    }
}
