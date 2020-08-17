package io.riju;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.cache.CacheResult;

@ApplicationScoped
@Path("/posts")
public class Blog {

    private static final Logger LOG = Logger.getLogger(Blog.class);

    @Inject
    @RestClient
    BlogPostService postService;

    TestService testService = new TestService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "blog")
    @Path("/{id}")
    @Counted(name = "getPostCount", description = "How many times getPost() was called.")
    @Timed(name = "getPostTimer", description = "A measure of how long it takes to run getPost().", unit = MetricUnits.MILLISECONDS)
    public BlogPost getPost(@PathParam String id){
        LOG.info("getPost");
        testService.doSomething();
        return postService.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "blog")
    @Path("/")
    @Counted(name = "getAllPostsCount", description = "How many times getAllPosts() was called.")
    @Timed(name = "getAllPostsTimer", description = "A measure of how long it takes to run getAllPosts().", unit = MetricUnits.MILLISECONDS)
    public Set<BlogPost> getAllPosts() {
        LOG.info("getAllPosts");
        return postService.getAllPosts();
    }
}