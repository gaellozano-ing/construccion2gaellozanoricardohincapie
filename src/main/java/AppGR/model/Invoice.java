
package appgr.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "personid")
    private Person PersonId;
    @ManyToOne
    @JoinColumn(name = "partnerid")
    private Partner partnerId;
    @Column (name = "creationdate")
    private Timestamp dateCreate;
    @Column (name = "amount")
    private double amount;
    @Column (name = "status")
    private String status;
    

    
}
