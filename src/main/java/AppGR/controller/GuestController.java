
package appgr.controller;
import java.sql.Timestamp;

import appgr.controller.validator.PersonValidator;
import appgr.controller.validator.InvoiceValidator;
import appgr.controller.validator.InvoiceDetailValidator;
import appgr.dto.PersonDto;

public class GuestController implements ControllerInterface {
    private PersonValidator personValidator;
    private InvoiceValidator invoiceValidator;
    private InvoiceDetailValidator invoiceDetailValidator;
    private static final String MENU = "Ingrese la opcion que desea realizar \n 1. Registrar consumo \n 2. Buscar factura \n 3. Pagar factura \n 4. Cerrar sesion";
    @Override
    public void session() throws Exception {
        boolean session = true;
        while(session){
            session = guestSession();
        }
    }
    
    private boolean guestSession(){
        try{
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return menu(option);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    
    private boolean menu(String option)throws Exception{
        switch(option){
            case "1":{
                this.generateConsuption();
                return true;
            }
            case "2":{
                this.searchInvoice();
                return true;
            }
            
            case "3":{
                System.out.println("Se ha cerrado la sesion");
                return false;
            }
            default:{
                System.out.println("Opcion invalida");
                return true;
            }
        }
    }
    
    public GuestController(){
        this.invoiceValidator = new InvoiceValidator();
        this.personValidator = new PersonValidator();
        this.invoiceDetailValidator = new InvoiceDetailValidator();
    }
    
    private void generateConsuption()throws Exception{
        
    }
    private void searchInvoice()throws Exception{}
}
