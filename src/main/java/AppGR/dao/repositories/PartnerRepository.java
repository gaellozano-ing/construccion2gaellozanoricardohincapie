
package appGr.dao.repositories;

import appgr.dto.PartnerDto;
import appgr.model.Partner;
import appgr.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository <Partner, Long>{

    public Partner findByid(Long id);

    public boolean existsById(Long id);
   
    public Partner findByMoney(double amount);
  
    public Partner findByuserid(User user);
    
   @Modifying
    @Transactional
    @Query("UPDATE Partner p SET p.money = :money WHERE p.userid = :userid")
    void updateMoneyByUserId(@Param("money") Double money, @Param("userid") Long userId);
  
 
    
}
