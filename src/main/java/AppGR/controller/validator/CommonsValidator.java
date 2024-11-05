
package appgr.controller.validator;

import org.springframework.stereotype.Component;

@Component
public abstract class CommonsValidator {
    public void isValidString(String element, String value) throws Exception{
        if (value.equals("")){
            throw new Exception (element + "no puede ser un valor vacio");
        }
    }
    
    public int isValidInterger(String element, String value) throws Exception {
        isValidString(element, value);
        try {
            return Integer.parseInt(value);
        }
        catch (Exception e){
            throw new Exception(element + "debe ser un valor valido");
        }
    }
    
    public long isValidLong(String element, String value) throws Exception{
        isValidString(element, value);
        try{
            return Long.parseLong(value);
        }
        catch (Exception e){
            throw new Exception (element + "debe ser un valor valido");
        }
    }
    
    public double isValidDouble(String element, String value)throws Exception{
        isValidString(element, value);
        try{
            return Double.parseDouble(value);
        }
        catch (Exception e){
            throw new Exception(element + "debe ser un valor valido");
        }
    }
    public boolean isValidBoolean(String element, String value) throws Exception {
        isValidString(element, value);
	try {
	    return Boolean.parseBoolean(value);
		}
        catch (Exception e) {
	     throw new Exception(element + " debe ser un valor valido");
		}
	}
}
