package jumpemotion.easyscheme;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jumpemotion.model.Citizen;
import jumpemotion.persistence.Database;


@Path("citizens")
public class CitizenResource {

 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Citizen> getAllCitizens(){
        return Database.getInstance().getAllCitizens();
               
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Citizen getCitizen(@PathParam("id") String id) {
        Citizen c = Database.getInstance().retrieveCitizen(id);
        return c;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateCitizen(Citizen toUpdate){
        Response r;
        if(Database.getInstance().updateCitizen(toUpdate)) {
            r = Response.ok().build();
        }
        else {
            r = Response.notModified().build();
        }
        return r;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCitizen(Citizen toCreate) {
        Response r;
        if (toCreate != null && toCreate.acceptable()) {
            if (Database.getInstance().persistCitizen(toCreate)) {
                r = Response.ok().build();
            } else {
                r = Response.notModified().build();
            }

        } else {
         r = Response.noContent().build();
        }
        return r;
    }
}
