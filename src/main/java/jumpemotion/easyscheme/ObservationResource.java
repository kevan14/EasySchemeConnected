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
import jumpemotion.common.IObservationService;
import jumpemotion.model.Observation;
import jumpemotion.persistence.CitizenDatabase;
import jumpemotion.service.ObservationService;

/**
 *
 * @author Kennet_Skole
 */
@Path("observations")
public class ObservationResource {

    private IObservationService service = ObservationService.getInstance();

    @GET
    @Path("/{ssn}")
    public List<Observation> getAllFromSsn(@PathParam("ssn") String ssn) {

        List<Observation> result = service.getAllFromSsn(ssn);
        if (result != null) {
            return result;
        }
        return null;
    }
    
    @POST
    @Path("/{ssn}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createObservation(@PathParam("ssn") String ssn, Observation toCreate) {
        Response r;
        Observation created = service.createObservation(ssn, toCreate);
        if(created != null) {
            r = Response.ok().type(MediaType.APPLICATION_XML).entity(created).build();
        }
        else {
            r = Response.notModified().build();
        }
        return r;
    }

}
