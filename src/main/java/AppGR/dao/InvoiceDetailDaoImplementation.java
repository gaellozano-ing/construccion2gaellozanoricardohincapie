
package appGr.dao;

import appGr.dao.repositories.InvoiceDetailRepository;
import appgr.dao.interfaces.InvoiceDetailDao;
import appgr.model.InvoiceDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao {
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;
   
    public void createInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
       invoiceDetailRepository.save(invoiceDetail);
    }
}
