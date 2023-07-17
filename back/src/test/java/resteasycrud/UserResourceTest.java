package resteasycrud;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;

import resteasycrud.model.User;
import resteasycrud.model.Endereco;
import resteasycrud.model.Telefone;



public class UserResourceTest {

    private static final String FULL_PATH = "http://localhost:8080/CRUD/restapi/users";

    @Test
    public void testListAllUsers() {

        final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client
            .target(FULL_PATH);
        String response = target.request().get(String.class);
        System.out.println(response);
    }

    @Test
    public void testGetUser() {

        final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client
            .target(FULL_PATH + "/100");
        Response response = target.request().get();
        User user = response.readEntity(User.class);
        System.out.println(user.toString());
        response.close();
    }

    @Test
    public void testCreateUser() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(FULL_PATH);
       
        List < Telefone > telefonesarray = new ArrayList < Telefone > ();
        Endereco bufferendereco = new Endereco("3", "Tijuca", "Rua alguma","34","1202","Rio de Janeiro","Rio de Janeiro", "23467854");
		Telefone buffertelefone = new Telefone("7","3", "934562345");
		telefonesarray.add(buffertelefone);
		       
        Response response = target.request()
            .post(Entity.entity(new User("3", "Amir","solteiro","BR","M","12/04/1988","Professor",
            		"ramesh@gmail.com","98734567823",null,null , bufferendereco,telefonesarray ), "application/json"));
        System.out.println(response.getStatus());
        response.close();
    }
   
    
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setName("Ram");
        user.setEmail("ram@gmail.com");
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(FULL_PATH + "/100");
        Response response = target.request()
            .put(Entity.entity(user, "application/json"));
        System.out.println(response.getStatus());
        response.close();
    }

    @Test
    public void testDeleteUser() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(FULL_PATH + "/100");
        Response response = target.request()
            .delete();
        System.out.println(response.getStatus());
        response.close();

        final ResteasyWebTarget target1 = client
            .target(FULL_PATH);
        String response1 = target1.request().get(String.class);
        System.out.println(response1);
    }

}