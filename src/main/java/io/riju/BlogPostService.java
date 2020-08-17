package io.riju;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/wp-json/wp/v2")
@RegisterRestClient
public interface BlogPostService {
    
    @GET
    @Path("/posts/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    BlogPost getById(@PathParam String id);

    @GET
    @Path("/posts/")
    @Produces(MediaType.APPLICATION_JSON)
    Set<BlogPost> getAllPosts();
}