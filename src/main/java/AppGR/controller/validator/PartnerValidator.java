
package appgr.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class PartnerValidator extends CommonsValidator {
    
 
    
    public void validType (String type) throws Exception{
        super.isValidString("El tipo de afiliacion del socio ", type);
    }
    
    public double validMoney (String money) throws Exception{
        return super.isValidDouble("Los fondos disponibles ", money);
    }
}
