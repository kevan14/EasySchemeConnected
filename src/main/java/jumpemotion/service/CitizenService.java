/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.service;

import java.util.List;
import jumpemotion.common.ICitizenService;
import jumpemotion.model.Citizen;
import jumpemotion.persistence.CitizenDatabase;
import jumpemotion.persistence.ICitizenPersister;

/**
 *
 * @author Kennet_Skole
 */
public class CitizenService implements ICitizenService {
    
    private static ICitizenService instance = new CitizenService();
    
    private CitizenService() {
        
    }
    
    public static ICitizenService getInstance() {
        return instance;
    }

    @Override
    public Citizen createCitizen(Citizen toCreate) {
        return CitizenDatabase.getInstance().createCitizen(toCreate);
    }

    @Override
    public Citizen getCitizen(String ssn) {
        return CitizenDatabase.getInstance().getCitizen(ssn);
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return CitizenDatabase.getInstance().getAllCitizens();
    }

    @Override
    public boolean deleteCitizen(Citizen toDelete) {
        return CitizenDatabase.getInstance().deleteCitizen(toDelete);
    }

    @Override
    public Citizen updateCitizen(Citizen toUpdate) {
        return CitizenDatabase.getInstance().updateCitizen(toUpdate);
    }
    
}
