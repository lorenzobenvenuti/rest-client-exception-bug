package it.lorenzobenvenuti.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class GreetingResource {

    @RestClient
    @Inject
    FooClient fooClient;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Foo hello(@PathParam("id") String id) {
        return fooClient.getFoo(id);
    }

}