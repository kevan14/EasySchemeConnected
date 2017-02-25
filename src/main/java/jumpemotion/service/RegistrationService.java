/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.service;

import java.util.List;
import jumpemotion.common.IRegistrationService;
import jumpemotion.model.Registration;
import jumpemotion.persistence.RegistrationDatabase;

/**
 *
 * @author Kennet_Skole
 */
public class RegistrationService implements IRegistrationService {
    
    private static IRegistrationService instance = new RegistrationService();
    
    private RegistrationService() {
        
    }
    
    public static IRegistrationService getInstance() {
        return instance;
    }

    @Override
    public Registration createRegistration(String observationID, Registration toCreate) {
        return RegistrationDatabase.getInstance().createRegistration(observationID, toCreate);
    }

    @Override
    public List<Registration> getAllRegistrationsFromObservationID(String observationID) {
        return RegistrationDatabase.getInstance().getAllRegistrationsFromObservationID(observationID);
    }
    
}
