/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.persistence;

import java.util.List;
import jumpemotion.model.Registration;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Kennet_Skole
 */
public interface IRegistrationPersister {
    
    public Registration createRegistration(String observationID, Registration toCreate);
    
    public List<Registration> getAllRegistrationsFromObservationID(String observationID);
    
}
