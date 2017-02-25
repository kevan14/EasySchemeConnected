/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jumpemotion.model.Observation;
import jumpemotion.model.Registration;

/**
 *
 * @author Kennet_Skole
 */
public class RegistrationDatabase implements IRegistrationPersister {
    
    private static IRegistrationPersister instance = new RegistrationDatabase();
    private Map<String, List<Registration>> registrations = new TreeMap<String, List<Registration>>();
    
    private RegistrationDatabase() {
        
    }
    
    public static IRegistrationPersister getInstance() {
        return instance;
    }
    


    @Override
    public Registration createRegistration(String observationID, Registration toCreate) {
if (!registrations.containsKey(observationID)) {
            ArrayList<Registration> list = new ArrayList<>();
            list.add(toCreate);
            registrations.put(observationID, list);
            return toCreate;
        } else {
            List<Registration> fromDB = registrations.get(observationID);
            fromDB.add(toCreate);
            registrations.replace(observationID, fromDB);

            if (!registrations.containsValue(fromDB)) {
                return null;
            }
        }

        return toCreate;

    }

    @Override
    public List<Registration> getAllRegistrationsFromObservationID(String observationID) {
        return registrations.get(observationID);
    }
    
}
