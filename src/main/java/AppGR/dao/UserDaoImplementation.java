
package appgr.dao;

import appGr.dao.repositories.UserRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import appgr.dao.interfaces.UserDao;
import appgr.dto.UserDto;
import appgr.helpers.Helper;
import appgr.model.Person;
import appgr.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class UserDaoImplementation implements UserDao{
    @Autowired 
    UserRepository userRepository;
    @Override
    public UserDto findByUserName(UserDto userDto) throws Exception {
    User user = userRepository.findByUserName(userDto.getUserName());
    return Helper.parse(user);
    }

    @Override
    public boolean existsByUserName(UserDto userDto) throws Exception {
      return userRepository.existsByUserName(userDto.getUserName());
      
    }

    @Override
    public void createUser(UserDto userDto) throws Exception {
         User user = Helper.parse(userDto);
         userRepository.save(user);
    } 
}
