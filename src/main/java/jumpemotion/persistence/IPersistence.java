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
public interface IPersistence {
    
    public boolean persistCitizen(Citizen toCreate);
    
    public Citizen retrieveCitizen(String id);
    
    public boolean updateCitizen(Citizen toUpdate);
    
    public boolean deleteCitizen(Citizen toDelete);
    
    public List<Citizen> getAllCitizens();
    
    public List<Observation> getObservationsFromSsn(String ssn);
    
    public List<Observation> getAllOBservations();
    
    public boolean addObservation(String ssn, String name, String creator);
    

    
}
