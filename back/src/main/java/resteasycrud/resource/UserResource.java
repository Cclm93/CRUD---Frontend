package resteasycrud.resource;

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

import resteasycrud.model.User;
import resteasycrud.service.UserService;






@Path("users")
public class UserResource {

    private UserService userService = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List < User > users = userService.findAll();

       
        
        
        if (!users.isEmpty()) {
            return Response.ok(users).header("Access-Control-Allow-Origin", "*").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    // Read
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") String id) {

        User user = userService.fetchBy(id);

        if (user.getId() != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //Create
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        boolean result = userService.create(user);
        if (result) {
            return Response.ok().status(Response.Status.CREATED).build();
        } else {
            return Response.notModified().build();
        }
    }

    //Update
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") long id, User user) {
        boolean result = userService.update(user);

        if (result) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }

    //Delete
    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") String id) {
        boolean result = userService.delete(id);

        if (result) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }}
