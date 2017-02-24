/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.persistence;

import java.util.List;
import jumpemotion.model.Citizen;

/**
 *
 * @author Kennet_Skole
 */
public interface IPersistence {
    
    public boolean persistCitizen(Citizen citizen);
    
    public Citizen retrieveCitizen(String id);
    
    public boolean updateCitizen(Citizen citizen);
    
    public List<Citizen> getAllCitizens();
    
}
