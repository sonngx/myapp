package io.fabric8.quickstarts.camel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
@Path("/sayHello")
public interface HelloService {
 
    @GET
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    String welcome();
    
    @GET
    @Path("/{a}")
    @Produces(MediaType.TEXT_PLAIN)
    String sayHello(@PathParam("a") String a);

}