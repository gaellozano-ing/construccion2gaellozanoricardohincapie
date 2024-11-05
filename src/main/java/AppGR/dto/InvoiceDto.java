
package appgr.dto;
import java.sql.Timestamp;

public class InvoiceDto {
    private long id;
    private PersonDto personId;
    private PartnerDto partnerId;
    private Timestamp creationDate;
    private double amount;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public InvoiceDto(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonDto getPersonId() {
        return personId;
    }

    public void setPersonId(PersonDto personId) {
        this.personId = personId;
    }

    public PartnerDto getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(PartnerDto partnerId) {
        this.partnerId = partnerId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }    


    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

 
    
}
