
package appgr.service.interfaces;
import appgr.dto.GuestDto;
import appgr.dto.PartnerDto;
import appgr.dto.UserDto;

public interface PartnerService {
    public void createGuest(GuestDto GuestDto)throws Exception;

    public void updateGuestStatus(GuestDto guestDto);

    public GuestDto getGuestById(long id)  throws Exception;

    public void addfunds() throws Exception ;

    public void createinvoice() throws Exception;
}