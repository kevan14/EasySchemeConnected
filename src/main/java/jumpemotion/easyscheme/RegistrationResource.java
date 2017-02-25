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
import jumpemotion.common.IRegistrationService;
import jumpemotion.model.Registration;
import jumpemotion.persistence.CitizenDatabase;
import jumpemotion.service.RegistrationService;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Kennet_Skole
 */
@Path("registrations")
public class RegistrationResource {

    private IRegistrationService service = RegistrationService.getInstance();
  
    @GET
    @Path("/{ObservationID}")
    public List<Registration> getAllRegistrationsFromObservationID(@PathParam("observationID") String observationID) {
        return service.getAllRegistrationsFromObservationID(observationID);
    }
    
    @POST
    @Path("/{observationID}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createRegistration(@PathParam("observationID") String observationID, Registration toCreate) {
        Response r;
        Registration reg = service.createRegistration(observationID, toCreate);
        if(reg != null) {
            r = Response.ok().type(MediaType.APPLICATION_XML).entity(reg).build();
        }
        else {
            r = Response.noContent().build();
        }
        return r;
    }
}
