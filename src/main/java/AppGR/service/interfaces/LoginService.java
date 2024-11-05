
package appgr.service.interfaces;
import appgr.dto.UserDto;

public interface LoginService {
    public void login(UserDto userDto)throws Exception;
    public void logout();
}
