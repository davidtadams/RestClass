package resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import person.Person;

@Path("/generic")
public class GenericResource {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(
            @DefaultValue("12345")
            @QueryParam("zipcode") String zipcode,
            @HeaderParam("x-name") String name
    ) {
        return "Hello, " + name + "  your zip code is: " + zipcode;
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String sayHello2() {
        return "<html><head><body>Testing";
    }
    
    @GET
    @Path("/extra/{thePrimaryKey}")
    public String sayExtra(@PathParam("thePrimaryKey") String pk) {
        return String.format("Here is the key %s", pk);
    }
    
    @DELETE
    @Path("/deleteme")
    public String sayDelete() {
        return "i was deleted";
    }
    
    @GET
    @Path("/extra/{primaryKey}")
    @Produces(MediaType.APPLICATION_XML)
    public Person xmlTest(@PathParam("primaryKey") Integer pk) {
        return new Person(pk, "David", "Adams");
    }

    @GET
    @Path("/extra/xx-{id}-yy-{idx}")
    @Produces(MediaType.TEXT_PLAIN)
    public String multiplePathSegments(
            @PathParam("id") String id,
            @PathParam("idx") String idx
    ) {
        return String.format("This is x: %s and y: %s", id, idx);
    }
    
}
