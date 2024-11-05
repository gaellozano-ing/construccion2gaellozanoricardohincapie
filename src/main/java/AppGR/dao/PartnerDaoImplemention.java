
package appgr.dao;

import appGr.dao.repositories.PartnerRepository;
import appgr.dto.UserDto;
import appgr.model.User;
import appgr.dao.interfaces.PartnerDao;
import appgr.dto.PartnerDto;
import appgr.helpers.Helper;
import appgr.model.Partner;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class PartnerDaoImplemention implements PartnerDao{
    @Autowired
    PartnerRepository PartnerRepository;
  
    @Override
    public void createPartner(PartnerDto partnerDto) throws Exception {
       Partner partner = Helper.parse(partnerDto);
        PartnerRepository.save(partner);
        partnerDto.setId(partner.getId());
    }

    
    @Override
     public boolean existById (UserDto UserDto) throws Exception {
        return PartnerRepository.existsById(UserDto.getId());
    }

    @Override
    public PartnerDto getMoneyByPartner(double amount) throws Exception {
        Partner partner = PartnerRepository.findByMoney(amount);
        if (partner == null) {
        System.out.println("no se encontró un socio con el monto: " + amount);
        return null;}
        return Helper.parse(partner);
    }
      @Transactional


    @Override
        public PartnerDto findByuserid(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        Partner partner = PartnerRepository.findByuserid(user);
              return Helper.parse(partner);
    }

    @Override
         public PartnerDto findById(PartnerDto PartnerDto) throws Exception {
         Partner partner = PartnerRepository.findByid(PartnerDto.getId());
         return Helper.parse(partner);
      
        }

    @Override
    public void addfunds(PartnerDto partnerDto) throws Exception {
      PartnerRepository.updateMoneyByUserId(partnerDto.getMoney(),partnerDto.getUserId().getId());
         }
}
    
        
       
    

