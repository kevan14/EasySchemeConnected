package jumpemotion.easyscheme;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jumpemotion.common.ICitizenService;
import jumpemotion.model.Citizen;
import jumpemotion.service.CitizenService;

@Path("citizens")
public class CitizenResource {

    private ICitizenService service = CitizenService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Citizen> getAllCitizens() {
        return service.getAllCitizens();
    }
    
    @GET
    @Path("/{ssn}")
    public Response getCitizenFromSsn(@PathParam("ssn") String ssn) {
        Citizen c = service.getCitizen(ssn);
        Response r;
        
        if(c != null) {
            r = Response.ok().type(MediaType.APPLICATION_XML).entity(c).build();
        }
        else {
            r = Response.noContent().build();
        }
     
        return r;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCitizen(Citizen toCreate) {
        Citizen c = service.createCitizen(toCreate);
        Response r;
        if(c != null) {
            r = Response.ok().type(MediaType.APPLICATION_XML).entity(c).build();
        }
        else {
            r = Response.notModified().build();
        }
        
        return r;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateCitizen(Citizen toUpdate) {
        Citizen c = service.updateCitizen(toUpdate);
        Response r;
        if(c != null) {
            r = Response.ok().type(MediaType.APPLICATION_XML).entity(c).build();
        }
        else {
            r = Response.notModified().build();
        }
        
        return r;
    }
    
    @DELETE
    @Path("/{ssn}")
    public Response deleteCitizen(@PathParam("ssn") String ssn) {
        Citizen c = service.getCitizen(ssn);
        Response r;
        if(c == null) {
            return Response.notModified().build();
        }
        if(service.deleteCitizen(c)) {
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }
        return r;
        
    }
 
}
