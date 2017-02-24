/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jumpemotion.model.Citizen;
import jumpemotion.model.Observation;
import jumpemotion.model.Region;
import jumpemotion.model.Registration;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Kennet_Skole
 */
public class Database implements IPersistence {

    private static IPersistence instance = new Database();
    private Map<String, Citizen> citizens = new HashMap<String, Citizen>();
    private Map<String, List<Observation>> observations = new HashMap<String, List<Observation>>();

    private Database() {
        init();
    }

    private void init() {

        citizens.put("12345678", new Citizen("12345678", "Kennet", "Vangsgaard", "Østervold 2, 3tv", Region.NORD));
        citizens.put("87654321", new Citizen("87654321", "Chistian", "Vallentin", "Aner det ikke", Region.MIDT));
        
        
        addObservation("12345678", "Fast Medicin", "Passer");
        addObservation("12345678", "Søvn", "Passer");
        addObservation("87654321", "PN", "Passer");
        addObservation("87654321", "Afføring", "Passer");
        

    }

    public static IPersistence getInstance() {
        return instance;
    }

    @Override
    public boolean persistCitizen(Citizen citizen) {
        if (citizens.containsKey(citizen.getSsn())) {
            return false;
        } else {
            citizens.put(citizen.getSsn(), citizen);
            return true;
        }
    }

    @Override
    public Citizen retrieveCitizen(String id) {
        Citizen c = citizens.get(id);
        return c;
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return new ArrayList<Citizen>(citizens.values());
    }

    @Override
    public boolean updateCitizen(Citizen citizen) {
        Citizen c = citizens.get(citizen.getSsn());
        if (c != null) {
            citizens.replace(citizen.getSsn(), citizen);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCitizen(Citizen toDelete) {
        if (citizens.containsKey(toDelete.getSsn())) {
            citizens.remove(toDelete.getSsn());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Observation> getObservationsFromSsn(String ssn) {
        return observations.get(ssn);
    }

    @Override
    public boolean addObservation(String ssn, String name, String creator) {
        
        if(!observations.containsKey(ssn)) {
            observations.put(ssn, new ArrayList<Observation>());
        }
        
        List<Observation> result = observations.get(ssn);
        for(Observation obs : result) {
            if(obs.getName().equals(name)) {
                return false;
            }
        }
        result.add(new Observation(name, ssn, creator));
        observations.replace(ssn, result);
        return true;
        
    }

    @Override
    public List<Observation> getAllOBservations() {
        List<Observation> result = new ArrayList<Observation>();
        for(List<Observation> list : observations.values()) {
            for(Observation inList : list) {
                result.add(inList);
            }
        }
        return result;
    }


}
