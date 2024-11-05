package appGr.dao.repositories;

import appgr.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceDetailRepository extends JpaRepository <InvoiceDetail,Long> {
    
}
