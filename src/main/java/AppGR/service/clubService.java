
package appgr.service;
import appgr.controller.Utils;
import appgr.dao.PersonDaoImplementation;
import appgr.dao.UserDaoImplementation;
import appgr.dao.interfaces.PersonDao;
import appgr.dao.interfaces.UserDao;
import appgr.dao.interfaces.GuestDao;
import appgr.dao.interfaces.PartnerDao;
import appgr.dto.GuestDto;
import appgr.dto.PartnerDto;
import appgr.dto.PersonDto;
import appgr.dto.UserDto;
import appgr.service.interfaces.AdminService;
import appgr.service.interfaces.LoginService;
import appgr.service.interfaces.PartnerService;
import appgr.dao.PartnerDaoImplemention;
import appgr.dao.GuestDaoImplementation;
import appgr.dao.interfaces.InvoiceDao;
import appgr.dao.interfaces.InvoiceDetailDao;
import appgr.dto.InvoiceDetailDto;
import appgr.dto.InvoiceDto;
import appgr.helpers.Helper;
import appgr.model.Invoice;
import appgr.model.InvoiceDetail;
import appgr.model.User;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@NoArgsConstructor
@Getter
@Setter
public class clubService implements LoginService, AdminService,PartnerService{
    @Autowired 
    private UserDao userDao;
    @Autowired 
    private PersonDao personDao;
    @Autowired 
    private GuestDao guestDao;
    @Autowired 
    private PartnerDao partnerDao;
    @Autowired 
    public static double addfunds;
    @Autowired 
    public static UserDto user;
     @Autowired
    private InvoiceDao invoicedao;
    @Autowired
    private InvoiceDetailDao invoicedetaildao;
   
  
    
  
    
    @Override
    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUserName(userDto);
        if(validateDto == null){
            throw new Exception("no existe usuario registrado");
        }
        if(!userDto.getPassword().equals(validateDto.getPassword())){
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRole(validateDto.getRole());
        user = validateDto;
    }

    @Override
    public void logout() {
        user = null;
        System.out.println("Se ha cerrado sesion");
    }

    public void CreatePartner(UserDto userDto) throws Exception {
        this.createUser(userDto);
        userDto=userDao.findByUserName(userDto);
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setDateCreated(new Timestamp(System.currentTimeMillis()));
        partnerDto.setMoney(50000);
        partnerDto.setType("regular");
        partnerDto.setUserId(userDto);
        partnerDao.createPartner(partnerDto);
    }
    
    @Override
   public void createGuest(GuestDto GuestDto) throws Exception {
        this.createUser(GuestDto.getUserId());
        guestDao.createGuest(GuestDto);

    }

    private void createUser(UserDto userDto) throws Exception{
        this.createPerson(userDto.getPersonId());
        PersonDto personDto = personDao.findByDocument(userDto.getPersonId());
        userDto.setPersonId(personDto);
        if(this.userDao.existsByUserName(userDto)){
            this.personDao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        try{
            this.userDao.createUser(userDto);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            this.personDao.deletePerson(userDto.getPersonId());
        }
    }

    private void createPerson(PersonDto personDto)throws Exception {
        if(this.personDao.existsByDocument(personDto)){
            throw new Exception("ya existe una persona con ese documento");
        }
        this.personDao.createPerson(personDto);
    }

    @Override
   public void createPartner(PartnerDto partnerDto) throws Exception {
        this.createUser(partnerDto.getUserId());
        UserDto userDto = userDao.findByUserName(partnerDto.getUserId());
        partnerDto.setUserId(userDto);
        this.partnerDao.createPartner(partnerDto);

    }

   
 

    public GuestDto getGuestById(long id, long guestid) throws Exception {
      return guestDao.getGuestById(guestid);
    
       
    }

    
    public void addfunds(UserDto User) throws Exception {
       UserDto user = clubService.user;
       PartnerDto partner = partnerDao.findByuserid(User);
       System.out.println("Bienvenido su monto actual es: "+partner.getMoney()+" y su tipo de socio es: "+partner.getType());
       System.out.println("Ingresa el monto que desea agregar");
       double monto =Double.parseDouble(Utils.getReader().nextLine());
       monto= partner.getMoney()+monto;
       addfunds=monto;
       if(partner.getType().equals("regular") && addfunds>=1000000){
           System.out.println("No puedes tener mas de 1000000");
           addfunds=addfunds - monto;
       }
       
       else if (partner.getType().equals("vip") && addfunds>=500000){
           System.out.println("No puedes tener mas de 500000");
       }
       partner.setMoney(addfunds);
       this.partnerDao.getMoneyByPartner(addfunds);
       this.partnerDao.addfunds(partner);
    }

  
    public void UpdateGuestStatus(GuestDto guestDto) throws Exception {
       guestDao.ActivateStatus(guestDto);
    }



    @Override
    public void createinvoice() throws Exception {
    
       double monto=0;
       String descripcion;
       UserDto userDto = clubService.user;
       PartnerDto partner = partnerDao.findByuserid(userDto);
       PersonDto person = personDao.findByDocument(userDto.getPersonId());
       System.out.println("Bienvenido "+partner.getUserId().getUserName()+" ingresa la cantidad de items a consumir");
       int items = Utils.getReader().nextInt();
       List <InvoiceDetailDto> invoices = new ArrayList<InvoiceDetailDto>();
       InvoiceDto invoiceDto = new InvoiceDto();
       invoiceDto.setPartnerId(partner);
       invoiceDto.setPersonId(person);
       invoiceDto.setStatus("Pago pendiente");
       invoiceDto.setCreationDate(new Timestamp(System.currentTimeMillis()));
          for (int i = 0; i < items; i++) {
              InvoiceDetailDto invoicedetail = new InvoiceDetailDto();
              invoicedetail.setInvoiceId(invoiceDto);
              invoicedetail.setItem(i+1);
              System.out.println("Ingrese el monto del item "+invoicedetail.getItem());
              invoicedetail.setAmount(Utils.getReader().nextDouble());
              System.out.println("Ingrese la descripcion del item "+invoicedetail.getItem());
              invoicedetail.setDescription("item: "+(i+1)+" "+Utils.getReader().next());
              monto=monto+invoicedetail.getAmount();
              invoices.add(invoicedetail);
          }
          invoiceDto.setAmount(monto);
       Invoice invoice=Helper.Parse(invoiceDto);
       invoicedao.createInvoice(invoice);
       
       for(InvoiceDetailDto detail:invoices){
           detail.setInvoiceId(invoiceDto);
          InvoiceDetail invoiceDetail = Helper.parse(detail);
          invoiceDetail.setInvoiceId(invoice);
          invoicedetaildao.createInvoiceDetail(invoiceDetail);
       }
        System.out.println("Factura creada");
        
       
   }

    @Override
    public void updateGuestStatus(GuestDto guestDto) {
    }

    @Override
    public GuestDto getGuestById(long guestId) throws Exception {
        return guestDao.getGuestById(guestId);
    }

    @Override
    public void addfunds() throws Exception {
    }
    

 

    
}

