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
import java.util.TreeMap;
import jumpemotion.model.Citizen;
import jumpemotion.model.Observation;
import jumpemotion.model.Region;
import jumpemotion.model.Registration;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Kennet_Skole
 */
public class CitizenDatabase implements ICitizenPersister {

    private static ICitizenPersister instance = new CitizenDatabase();
    private Map<String, Citizen> citizens = new TreeMap<String, Citizen>();

    private CitizenDatabase() {
        init();
    }

    private void init() {

        citizens.put("12345678", new Citizen("12345678", "Kennet", "Vangsgaard", "Østervold 2, 3tv", Region.NORD));
        citizens.put("87654321", new Citizen("87654321", "Chistian", "Vallentin", "Aner det ikke", Region.MIDT));

    }

    public static ICitizenPersister getInstance() {
        return instance;
    }

    @Override
    public Citizen createCitizen(Citizen toCreate) {

        if (citizens.containsKey(toCreate.getSsn())) {
            return null;
        }

        citizens.put(toCreate.getSsn(), toCreate);
        return toCreate;
    }

    @Override
    public Citizen getCitizen(String ssn) {
        return citizens.get(ssn);
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return new ArrayList(citizens.values());
    }

    @Override
    public boolean deleteCitizen(Citizen toDelete) {

        if (citizens.remove(toDelete.getSsn(), toDelete)) {
            return true;
        }

        return false;
    }

    @Override
    public Citizen updateCitizen(Citizen toUpdate) {
        citizens.replace(toUpdate.getSsn(), toUpdate);
        return citizens.get(toUpdate.getSsn());
    }

}
