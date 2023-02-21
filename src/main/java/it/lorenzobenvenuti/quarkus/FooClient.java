
package it.lorenzobenvenuti.quarkus;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "foo-client")
@ApplicationScoped
@Path("/")
public interface FooClient {

    @GET
    @Path("/foo/{id}")
    Foo getFoo(@PathParam("id") String id);

}
