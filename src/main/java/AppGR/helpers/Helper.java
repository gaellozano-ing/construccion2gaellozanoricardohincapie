
package appgr.helpers;

import appgr.dto.GuestDto;
import appgr.dto.InvoiceDetailDto;
import appgr.dto.InvoiceDto;
import appgr.dto.PartnerDto;
import appgr.dto.PersonDto;
import appgr.dto.UserDto;
import appgr.model.Guest;
import appgr.model.Invoice;
import appgr.model.InvoiceDetail;
import appgr.model.Partner;
import appgr.model.Person;
import appgr.model.User;


public abstract class Helper {
    public static PersonDto parse(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setDocument(person.getDocument());
        personDto.setCellPhone(person.getCellPhone());
        personDto.setName(person.getName());
        return personDto;
    }
    public static Person parse(PersonDto personDto) {
	Person person = new Person();
	person.setId(personDto.getId());
	person.setDocument(personDto.getDocument());
	person.setCellPhone(personDto.getCellPhone());
	person.setName(personDto.getName());
	return person;
    }
    public static UserDto parse(User user) {
	UserDto userDto = new UserDto();
        if(user.getPersonId()!=null){
            userDto.setPersonId(parse(user.getPersonId()));
        }
	userDto.setId(user.getId());
	userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setUserName(user.getUserName());
        userDto.setPersonId(parse(user.getPersonId()));
	return userDto;
	}
	
    public static User parse(UserDto userDto) {
	User user = new User();
        if(userDto.getPersonId()!=null){
            user.setPersonId(parse(userDto.getPersonId()));
        }
	user.setId(userDto.getId());
	user.setPassword(userDto.getPassword());
	user.setRole(userDto.getRole());
	user.setUserName(userDto.getUserName());
	return user;
    }
    
    public static PartnerDto parse(Partner partner) {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setId(partner.getId());
        partnerDto.setMoney(partner.getMoney());
        partnerDto.setDateCreated(partner.getDateCreated());
        partnerDto.setType(partner.getType());
        partnerDto.setUserId(parse(partner.getUserid()));
        return partnerDto;
    }
    
    public static Partner parse(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        partner.setMoney(partnerDto.getMoney());
        partner.setDateCreated(partnerDto.getDateCreated());
        partner.setType(partnerDto.getType());
        partner.setUserid(parse(partnerDto.getUserId()));
        return partner;    
    }
    
    public static Guest parse(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setStatus(guestDto.getStatus());
        guest.setPartnerId(parse(guestDto.getPartnerId()));
        guest.setUserId(parse(guestDto.getUserId()));
        return guest;
    }
    
    public static GuestDto parse(Guest guest) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setStatus(guest.getStatus());
        guestDto.setPartnerId(parse(guest.getPartnerId()));
        guestDto.setUserId(parse(guest.getUserId()));
        return guestDto;
        
    }
        
    public static Invoice Parse(InvoiceDto invoiceDto){
         if (invoiceDto == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setAmount(invoiceDto.getAmount());
        invoice.setDateCreate(invoiceDto. getCreationDate());
        invoice.setId(invoiceDto.getId());
        invoice.setPartnerId(parse(invoiceDto.getPartnerId()));
        invoice.setPersonId(parse(invoiceDto.getPersonId()));
        invoice.setStatus(invoiceDto.getStatus());
        
        return invoice;
    }
      public static InvoiceDetailDto Parse(InvoiceDetail invoiceDetail){
        if (invoiceDetail == null) {
            return null;
        }
        InvoiceDetailDto invoicedetaildto= new InvoiceDetailDto ();
        invoicedetaildto.setAmount(invoiceDetail.getAmount());
        invoicedetaildto.setDescription(invoiceDetail.getDescription());
        invoicedetaildto.setId(invoiceDetail.getId());
        invoicedetaildto.setInvoiceId(invoicedetaildto.getInvoiceId());
        invoicedetaildto.setItem(invoiceDetail.getItem());
        return invoicedetaildto;
        
    }
      public static InvoiceDetail parse(InvoiceDetailDto invoiceDetailDto){
        if (invoiceDetailDto == null) {
            return null;
        }
        InvoiceDetail invoiceDetail = new InvoiceDetail ();
        invoiceDetail.setAmount(invoiceDetailDto.getAmount());
        invoiceDetail.setDescription(invoiceDetailDto.getDescription());
        invoiceDetail.setId(invoiceDetailDto.getId());
        invoiceDetail.setInvoiceId(Parse(invoiceDetailDto.getInvoiceId()));
        invoiceDetail.setItem(invoiceDetailDto.getItem());
        return invoiceDetail;
    }
      
    }

