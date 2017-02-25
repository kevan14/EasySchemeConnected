/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.persistence;

import java.util.List;
import jumpemotion.model.Observation;

/**
 *
 * @author Kennet_Skole
 */
public interface IObservationPersister {
    
    public Observation createObservation(String ssn, Observation toCreate);
    
    public List<Observation> getAllFromSsn(String ssn);
    
    
}
