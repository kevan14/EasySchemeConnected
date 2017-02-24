/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpemotion.easyscheme;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jumpemotion.model.Registration;
import jumpemotion.persistence.Database;

/**
 *
 * @author Kennet_Skole
 */
@Path("registrations")
public class RegistrationResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Registration> getAllRegistrations() {
        return Database.getInstance().getAllRegistrations();
    }
    
    @GET
    @Path("/{ssn}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Registration> getAllRegistrationsFromSsn(@PathParam("ssn") String ssn) {
        return Database.getInstance().getAllRegistrationsFromSsn(ssn);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response addRegistration(Registration toRegister) {
        Response r = null;
        if (toRegister != null) {
            if (Database.getInstance().addRegistrationToObservation(toRegister.getObservationID(), toRegister.getRegistration(), toRegister.getRegisteredBy())) {
                r = Response.ok().build();
            } else {
                r = Response.noContent().build();
            }

        }
        return r;
    }

}
