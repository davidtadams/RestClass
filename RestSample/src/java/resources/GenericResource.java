package resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("generic")
public class GenericResource {

    @GET
    public String sayHello() {
        return "Hello hello hello";
    }
    
    @GET
    @Path("extra")
    public String sayExtra() {
        return "some extra stuff";
    }
    
    @DELETE
    @Path("deleteme")
    public String sayDelete() {
        return "i was deleted";
    }
}
