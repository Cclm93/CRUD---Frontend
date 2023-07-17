package resteasycrud.resource;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/restapi")
public class RestEasyServices extends Application {

    private Set < Object > singletons = new HashSet < Object > ();

    public RestEasyServices() {
        singletons.add(new UserResource());
    }

    @Override
    public Set < Object > getSingletons() {
        return singletons;
    }
    
    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "Hello";
    }
}