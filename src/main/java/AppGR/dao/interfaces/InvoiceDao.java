
package appgr.dao.interfaces;

import appgr.model.Invoice;


public interface InvoiceDao {
  public void createInvoice(Invoice invoice) throws Exception;
}
