
package appgr.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter

public class InvoiceValidator extends CommonsValidator{
    

    public double validAmount (String amount) throws Exception{
        return super.isValidDouble("El monto total ", amount);
    }
    
    public void validItems(String items)throws Exception{
        super.isValidString("Items de la factura", items);
    }
}
