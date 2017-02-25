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

/**
 *
 * @author Kennet_Skole
 */
public class ObservationDatabase implements IObservationPersister {

    private static IObservationPersister instance = new ObservationDatabase();
    private Map<String, List<Observation>> observations = new TreeMap<String, List<Observation>>();

    private ObservationDatabase() {
        init();
    }

    public static IObservationPersister getInstance() {
        return instance;
    }
    
    private void init() {
        Observation o1 = new Observation("Fast medicin", "12345678", "TH");
        o1.addPreparedRegistration("Morgen ( 4 stk )");
        o1.addPreparedRegistration("Middag ( 2 stk )");
        o1.addPreparedRegistration("Aften  ( 3 stk )");
        Observation o2 = new Observation("Fast medicin", "87654321", "HA");
        o2.addPreparedRegistration("Morgen ( 4 stk )");
        o2.addPreparedRegistration("Nat ( 4 stk )");
        
        createObservation("12345678", o1);
        createObservation("87654321", o2);
        
    }

    @Override
    public Observation createObservation(String ssn, Observation toCreate) {
        if (!observations.containsKey(ssn)) {
            ArrayList<Observation> list = new ArrayList<>();
            list.add(toCreate);
            observations.put(ssn, list);
            return toCreate;
        } else {
            List<Observation> fromDB = observations.get(ssn);
            fromDB.add(toCreate);
            observations.replace(ssn, fromDB);

            if (!observations.containsValue(fromDB)) {
                return null;
            }
        }

        return toCreate;

    }

    @Override
    public List<Observation> getAllFromSsn(String ssn) {
        return observations.get(ssn);
    }


    

}
