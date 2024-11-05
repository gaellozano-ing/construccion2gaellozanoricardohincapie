
package appGr.dao.repositories;

import appgr.model.Guest;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuestRepository extends JpaRepository <Guest, Long>   {


    public boolean existsById(long id);
     Optional<Guest> findById(Long guestId);
 
 
}
