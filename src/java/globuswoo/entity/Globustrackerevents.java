/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "globustrackerevents")
public class Globustrackerevents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GlobustrackereventId", nullable = false)
    private Integer globustrackereventId;
    @Basic(optional = false)
    @Column(name = "EventName", nullable = false, length = 255)
    private String eventName;
    @Basic(optional = false)
    @Column(name = "EventDescription", nullable = false, length = 255)
    private String eventDescription;
    @Basic(optional = false)
    @Column(name = "EventDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    @Basic(optional = false)
    @Column(name = "AddedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    public Globustrackerevents() {
    }

    public Globustrackerevents(Integer globustrackereventId) {
        this.globustrackereventId = globustrackereventId;
    }

    public Globustrackerevents(Integer globustrackereventId, String eventName, String eventDescription, Date eventDate, Date addedDate) {
        this.globustrackereventId = globustrackereventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.addedDate = addedDate;
    }

    public Integer getGlobustrackereventId() {
        return globustrackereventId;
    }

    public void setGlobustrackereventId(Integer globustrackereventId) {
        this.globustrackereventId = globustrackereventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (globustrackereventId != null ? globustrackereventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Globustrackerevents)) {
            return false;
        }
        Globustrackerevents other = (Globustrackerevents) object;
        if ((this.globustrackereventId == null && other.globustrackereventId != null) || (this.globustrackereventId != null && !this.globustrackereventId.equals(other.globustrackereventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "globuswoo.entity.Globustrackerevents[ globustrackereventId=" + globustrackereventId + " ]";
    }
    
}
