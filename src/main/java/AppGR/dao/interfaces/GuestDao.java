
package appgr.dao.interfaces;

import appgr.dto.GuestDto;
import appgr.dto.UserDto;

public interface GuestDao {
    public void createGuest(GuestDto guestDto)throws Exception;
    public boolean existsById(GuestDto GuestDto) throws Exception;
    public GuestDto getGuestById(long guestId) throws Exception;
    public void ActivateStatus(GuestDto guestDto) throws Exception;
}
