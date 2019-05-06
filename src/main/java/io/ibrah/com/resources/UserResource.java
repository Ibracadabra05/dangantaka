package io.ibrah.com.resources;

import io.ibrah.com.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 * Created by ibrahimhamisu on 4/30/19.
 */
@Path("user/")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private Connection userConnection;

    public UserResource(Connection userConnection) {
        this.userConnection = userConnection;
    }

    @GET
    @Path("{id}")
    public User getUser(final @PathParam("id") Long userId) {
        return new User();
    }

    @GET
    @Path("{id}/followers/")
    public User[] getFollowers(final @PathParam("id") Long userId) {
        return  new User[5];
    }

    @GET
    @Path("{id}/follows/")
    public User[] getFollows(final @PathParam("id") Long userId) {
        return new User[3];
    }

    @GET
    public User[] getAllUsers(){
        try {
            Statement stmt = this.userConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2));
            }
            this.userConnection.close();

        } catch (SQLException e) {
            System.out.println(e.getStackTrace().toString());
        }
        return new User[10];
    }
}
