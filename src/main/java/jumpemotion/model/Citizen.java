/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kennet_Skole
 */
@XmlRootElement
public class Citizen {

    private String ssn;
    private String firstName;
    private String lastName;
    private String address;
    private Region region;

    //no op constructor
    public Citizen() {

    }

    public Citizen(String ssn, String firstName, String lastName, String address, Region region) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean acceptable() {
        if (ssn != null && firstName != null && lastName != null) {
            return true;
        } else {
            return false;
        }
    }

}
