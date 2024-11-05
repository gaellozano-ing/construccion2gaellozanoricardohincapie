
package appgr.dao.interfaces;

import appgr.dto.PartnerDto;
import appgr.dto.UserDto;


public interface PartnerDao {
    public void createPartner(PartnerDto partnerDto)throws Exception;
    
    public boolean  existById(UserDto userDto)throws Exception;
    public PartnerDto findByuserid(UserDto userDto) throws Exception;
    public PartnerDto getMoneyByPartner(double getMoney) throws Exception;
    public void addfunds(PartnerDto partnerDto) throws Exception;
    public PartnerDto findById(PartnerDto PartnerDto) throws Exception;
}
