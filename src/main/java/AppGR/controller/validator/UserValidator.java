package appgr.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class UserValidator extends CommonsValidator{
    
 
    public void validUserName (String userName) throws Exception{
        super.isValidString("El nombre de usuario ", userName);
    }
    
    public void validRole (String role) throws Exception{
        super.isValidString("El rol del usuario ", role);
    }
    
    public void validPassword (String password) throws Exception{
        super.isValidString("La contrasenia del usuario ", password);
    }
}
