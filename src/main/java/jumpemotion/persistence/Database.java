/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jumpemotion.model.Citizen;
import jumpemotion.model.Region;

/**
 *
 * @author Kennet_Skole
 */
public class Database implements IPersistence {

    private static IPersistence instance = new Database();
    private Map<String, Citizen> citizens = new HashMap<String, Citizen>();

    private Database() {
        init();
    }

    private void init() {

        citizens.put("12345678", new Citizen("12345678", "Kennet", "Vangsgaard", "Østervold 2, 3tv", Region.NORD));
        citizens.put("87654321", new Citizen("87654321", "Chistian", "Vallentin", "Aner det ikke", Region.MIDT));
    }

    public static IPersistence getInstance() {
        return instance;
    }

    @Override
    public boolean persistCitizen(Citizen citizen) {
        try {
            citizens.put(citizen.getSsn(), citizen);
        } catch (Exception e) {
            return false;
        }
        return true;
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

}
