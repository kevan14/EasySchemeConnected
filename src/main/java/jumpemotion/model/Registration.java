/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kennet_Skole
 */
@XmlRootElement
public class Registration {
    
    private Date created; 
    private String registeredBy;
    private String observationID;
    private String registration;
    
    public Registration() {
        
    }
    
    public Registration(String registeredBy, String observationId, String Registration) {
        this.created = new Date();
        this.registeredBy = registeredBy;
        this.observationID = observationId;
        this.registration = Registration;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    public String getObservationID() {
        return observationID;
    }

    public void setObservationID(String observationID) {
        this.observationID = observationID;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
    
    
    
}
