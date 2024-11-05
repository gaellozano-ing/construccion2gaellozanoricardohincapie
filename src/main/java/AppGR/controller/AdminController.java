
package appgr.controller;

import AppGR.controller.request.CreateUserRequest;
import appgr.controller.validator.PersonValidator;
import appgr.controller.validator.UserValidator;
import appgr.dto.PartnerDto;
import appgr.dto.PersonDto;
import appgr.dto.UserDto;
import appgr.service.clubService;
import appgr.service.interfaces.AdminService;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@NoArgsConstructor
public class AdminController implements ControllerInterface{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private AdminService service;
    private static final String MENU = "Ingrese la opcion que desea \n 1. para crear un socio \n 2. cerrar sesion \n";
    
  
    @Override
    public void session() throws Exception { 
 
        
    
    }

    
    private ResponseEntity createPartner(@RequestBody CreateUserRequest request) throws Exception{
        try{String name= request.getName();
        personValidator.validName(name);    
        long document=request.getDocument();
        long cellPhone = request.getCellphone();
        String username  = request.getUsername();
        userValidator.validUserName(username);
        String password = request.getPassword();
        userValidator.validPassword(password);
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setDocument(document);
        personDto.setCellPhone(cellPhone);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(username);
        userDto.setPassword(password);
        userDto.setRole("partner");
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setUserId(userDto);
        partnerDto.setDatecreated(new Timestamp(System.currentTimeMillis()));
        partnerDto.setMoney(50000);
        partnerDto.setType("regular");
        partnerDto.setUserId(userDto);
        this.service.createPartner(partnerDto);
        return new ResponseEntity<>("el usuario se ha creado exitosamente",HttpStatus.OK);
        
       }catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }

@GetMapping("/")
    public String vive(){
        return "vive";
    }
}