
package appgr.controller;
import AppGR.controller.request.ChangeStatusRequest;
import AppGR.controller.request.CreateUserRequest;
import AppGR.controller.request.addFundsRequest;
import java.sql.Timestamp;
import appgr.controller.validator.PersonValidator;
import appgr.controller.validator.UserValidator;
import appgr.dao.interfaces.InvoiceDao;
import appgr.dao.interfaces.PartnerDao;
import appgr.dao.interfaces.UserDao;
import appgr.dto.GuestDto;
import appgr.dto.PersonDto;
import appgr.dto.UserDto;
import appgr.dto.PartnerDto;
import appgr.service.clubService;
import static appgr.service.clubService.addfunds;
import appgr.service.interfaces.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PartnerController implements ControllerInterface{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PartnerService service;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private UserDao userdao;
     @Autowired
    private InvoiceDao invoicedao;
    
    private static final String MENU = "Ingrese la opcion que desea realizar \n 1. Crear invitado \n 12. Cerrar sesion";

    @Override
    public void session() throws Exception {
	}
    
    public PartnerController(){
        this.personValidator = new PersonValidator();
        this.userValidator= new UserValidator();
        this.service = new clubService();
    }
    
     @PostMapping("/Guest")
         private ResponseEntity createGuest(@RequestBody CreateUserRequest request) throws Exception{
       try{    
        String name = request.getName();
        personValidator.validName(name);
        long document = (request.getDocument());
        long Cellphone =request.getCellphone();
        String userName = request.getUsername();
        userValidator.validUserName(userName);
        String password = request.getPassword();
        userValidator.validPassword(password);
         PersonDto personDto = new PersonDto();
         personDto.setName(name);
         personDto.setDocument (document);
         personDto.setCellPhone(Cellphone);
         UserDto userDto = new UserDto();
         userDto.setUserName(userName);
         userDto.setPassword(password);
         userDto.setPersonId(personDto);
         userDto.setRole("Guest");
         GuestDto guestDto = new GuestDto();
         PartnerDto partnerDto = new PartnerDto();
         partnerDto.setId(request.getPartnerid());
         this.partnerDao.findById(partnerDto);
         guestDto.setPartnerId(partnerDto);
         guestDto.setUserId(userDto);
         guestDto.setStatus("inactivo");
         this.service.createGuest(guestDto);
         System.out.println("se ha creado el Invitado exitosamente");
         return new ResponseEntity<>("el usuario se creo exitosamente",HttpStatus.OK);
                }catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }        
    }
    @PostMapping("/activateGuest")
 private ResponseEntity activateGuest(@RequestBody ChangeStatusRequest request) throws Exception{
        try{ 
        long id = request.getGuestId();
         GuestDto guestDto = service.getGuestById(id);
         guestDto.setStatus("Activo");        
         service.updateGuestStatus(guestDto);
          return new ResponseEntity<>("el usuario se ha activado exitosamente",HttpStatus.OK);
        }
        catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
        }

      @PostMapping("/desactivateGuest")      
    private ResponseEntity desactivateGuest(@RequestBody ChangeStatusRequest request) throws Exception{
        try{ 
        long id= request.getGuestId();
        GuestDto guestdto = service.getGuestById(id);
        if (guestdto == null) {
        System.out.println("El invitado con ID " + id + " no existe.");
        return new ResponseEntity<>("El invitado no existe", HttpStatus.NOT_FOUND);}
        guestdto.setStatus("Inactivo");
        service.updateGuestStatus(guestdto);
           return new ResponseEntity<>("el usuario se ha desactivado exitosamente",HttpStatus.OK);
       }
     catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
        
    }
    @PostMapping("/addfunds")
    private ResponseEntity addfunds(@RequestBody addFundsRequest request) throws Exception{
          try{PartnerDto partner = new PartnerDto();
          partner.setId(request.getPartnerId());
        PartnerDto partnerdto=partnerDao.findById(partner);
        double monto = request.getAmount();
        partner.setId(request.getPartnerId());
        monto = partner.getMoney() + monto;
        UserDto user = new UserDto ();
        user.setUserName(request.getUsername());
        UserDto userdto = new UserDto();
        userdto=userdao.findByUserName(user);
        partner.setUserId(userdto);
        addfunds = monto;
        addfunds=monto+addfunds;
        if (partnerdto.getType().equals("regular") && addfunds >= 1000000) {
            System.out.println("No puedes tener mas de 1000000");
        addfunds = addfunds - monto;
        } else if (partnerdto.getType().equals("vip") && addfunds >= 5000000) {
            System.out.println("No puedes tener mas de 5000000");
        }
        partnerdto.setMoney(addfunds);
        this.partnerDao.getMoneyByPartner(addfunds);
        this.partnerDao.addfunds(partnerdto);
          return new ResponseEntity<>("el usuario se han agregado fondos  exitosamente",HttpStatus.OK);
       }
        catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
        
    
   }
     
    public void createinvoice() throws Exception {
       this.service.createinvoice();
       
   }
}