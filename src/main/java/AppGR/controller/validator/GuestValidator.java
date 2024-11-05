
package appgr.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter

public class GuestValidator extends CommonsValidator{
    
   
    
    public void validStatus ( String status)throws Exception{
        super.isValidString("el estado del invitado ", status);
    }
}
