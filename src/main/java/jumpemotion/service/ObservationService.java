/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.service;

import java.util.List;
import jumpemotion.common.IObservationService;
import jumpemotion.model.Observation;
import jumpemotion.persistence.ObservationDatabase;

/**
 *
 * @author Kennet_Skole
 */
public class ObservationService implements IObservationService{
    
    private static IObservationService instance = new ObservationService();
    
    private ObservationService() {
        
    }
    
    public static IObservationService getInstance() {
        return instance;
    }
    
    @Override
    public Observation createObservation(String ssn, Observation newObservation) {
        return ObservationDatabase.getInstance().createObservation(ssn, newObservation);
    }


    @Override
    public List<Observation> getAllFromSsn(String ssn) {
        return ObservationDatabase.getInstance().getAllFromSsn(ssn);
    }
    
}
