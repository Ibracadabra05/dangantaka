package io.ibrah.com.resources;

import io.ibrah.com.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ibrahimhamisu on 4/30/19.
 */
@Path("user/")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Path("{id}")
    public User getUser(final @PathParam("id") Long userId) {
        return new User();
    }
}
