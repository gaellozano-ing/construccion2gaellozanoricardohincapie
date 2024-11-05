
package appgr.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter

public class PersonValidator extends CommonsValidator{
    
    public void validName (String name) throws Exception{
        super.isValidString("El nombre de la persona ", name);
    }
    
    public long validDocument (String document) throws Exception{
       return super.isValidLong("La cedula de la persona ", document);
    }
    
    public long validCellPhone (String cellPhone) throws Exception{
        return super.isValidLong("El telefono de la persona ", cellPhone);
    }
}
