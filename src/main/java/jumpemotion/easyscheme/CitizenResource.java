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
import jumpemotion.model.Citizen;
import jumpemotion.persistence.Database;

@Path("citizens")
public class CitizenResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Citizen> getAllCitizens() {
        return Database.getInstance().getAllCitizens();

    }

}
