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
import jumpemotion.model.Observation;
import jumpemotion.persistence.Database;

/**
 *
 * @author Kennet_Skole
 */
@Path("observations")
public class ObservationResource {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Observation> getAllObservations() {
        return Database.getInstance().getAllOBservations();
    }

    @GET
    @Path("/{ssn}")
    public List<Observation> getAllObservationsFromSsn(@PathParam("ssn") String ssn) {
        return Database.getInstance().getObservationsFromSsn(ssn);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createObservation(Observation toCreate) {
        Response r = null;
        if (toCreate != null && toCreate.acceptable()) {

            if (Database.getInstance().addObservation(toCreate.getSsnRelation(), toCreate.getName(), toCreate.getCreatedBy())) {
                r = Response.ok().build();
            } else {
                r = Response.noContent().build();
            }
        }
       

        return r;

    }

}
