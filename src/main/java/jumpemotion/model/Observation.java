/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.model;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kennet_Skole
 */
@XmlRootElement
public class Observation {

    private String id  = UUID.randomUUID().toString();
    private String ssnRelation;
    private String name;
    private List<String> prepared;
    private Date created;
    private String createdBy;

    public Observation() {

    }

    public Observation(String name, String ssnRelation, String creator) {
        this.name = name;
        this.ssnRelation = ssnRelation;
        this.created = new Date();
        this.createdBy = creator;
        this.prepared = new ArrayList<String>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void addPreparedRegistration(String prepared) {
        this.prepared.add(prepared);
    }

    public String getSsnRelation() {
        return ssnRelation;
    }

    public void setSsnRelation(String ssnRelation) {
        this.ssnRelation = ssnRelation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPrepared() {
        return prepared;
    }

    public void setPrepared(List<String> prepared) {
        this.prepared = prepared;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean acceptable() {
        if (ssnRelation != null && name != null && createdBy != null) {
            return true;
        } else {
            return false;

        }
    }

}
