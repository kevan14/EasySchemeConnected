/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.persistence;

import java.util.List;
import jumpemotion.model.Citizen;
import jumpemotion.model.Observation;
import jumpemotion.model.Registration;

/**
 *
 * @author Kennet_Skole
 */
public interface ICitizenPersister {

    public Citizen createCitizen(Citizen toCreate);
    
    public Citizen getCitizen(String ssn);
    
    public List<Citizen> getAllCitizens();
    
    public boolean deleteCitizen(Citizen toDelete);
    
    public Citizen updateCitizen(Citizen toUpdate);
}
