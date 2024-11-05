
package appgr.dao;


import appGr.dao.repositories.GuestRepository;
import appgr.dao.interfaces.GuestDao;
import appgr.helpers.Helper;
import appgr.model.Guest;
import appgr.dto.GuestDto;
import appgr.dto.UserDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import appgr.model.Partner;
import appgr.model.User;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class GuestDaoImplementation implements GuestDao{

    @Autowired
    GuestRepository guestrepository;
      @Override
      
    public void createGuest(GuestDto guestDto) throws Exception {
      Guest guest = Helper.parse(guestDto);
      guestrepository.save(guest);
      guestDto.setId(guest.getId());
    }  

   
     
    @Override
    public boolean existsById(GuestDto GuestDto) throws Exception {
         return guestrepository.existsById(GuestDto.getId());
                
	}
    @Override
    public GuestDto getGuestById(long guestId) throws Exception{
         Optional<Guest> optionalGuest = guestrepository.findById(guestId);
         return Helper.parse(optionalGuest.get());
             
     }
    @Override
    public void ActivateStatus(GuestDto guestDto) throws Exception{
         Guest  guest= Helper.parse(guestDto);
         guestrepository.save(guest);
     }

   
    }

