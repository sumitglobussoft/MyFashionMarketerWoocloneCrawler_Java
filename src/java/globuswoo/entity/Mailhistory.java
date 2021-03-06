package globuswoo.entity;
// Generated May 23, 2013 8:20:10 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mailhistory generated by hbm2java
 */
@Entity
@Table(name="mailhistory")
public class Mailhistory  implements java.io.Serializable {


     private Integer mailHistoryId;
     private Customers customers;
     private String emailId;
     private Date mailSentOn;

    public Mailhistory() {
    }

    public Mailhistory(Customers customers, String emailId, Date mailSentOn) {
       this.customers = customers;
       this.emailId = emailId;
       this.mailSentOn = mailSentOn;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="MailHistoryId", unique=true, nullable=false)
    public Integer getMailHistoryId() {
        return this.mailHistoryId;
    }
    
    public void setMailHistoryId(Integer mailHistoryId) {
        this.mailHistoryId = mailHistoryId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CustomerId", nullable=false)
    public Customers getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    
    @Column(name="EmailId", nullable=false, length=50)
    public String getEmailId() {
        return this.emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="MailSentOn", nullable=false, length=0)
    public Date getMailSentOn() {
        return this.mailSentOn;
    }
    
    public void setMailSentOn(Date mailSentOn) {
        this.mailSentOn = mailSentOn;
    }




}


