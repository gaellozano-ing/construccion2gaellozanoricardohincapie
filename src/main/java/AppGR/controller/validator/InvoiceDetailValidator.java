
package appgr.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter

public class InvoiceDetailValidator extends CommonsValidator {
    

    
    public int validItem (String item) throws Exception{
        return super.isValidInterger("El numero del item ", item);
    }
    
    public void validDescription (String description) throws Exception{
        super.isValidString("La descripcion de la factura ", description);
    }
    
    public double validAmountItem (String amountItem) throws Exception{
        return super.isValidDouble("El valor del item ", amountItem);
    }
}
