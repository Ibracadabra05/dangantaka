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
import java.util.*;


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
    public User getUser(final @PathParam("id") int userId) {

        User user = null;

        try {
            Statement stmt = this.userConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + Integer.toString(userId));

            if (rs.next()){
                user = new User(rs.getInt(1), rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // TODO: Throw 404 when no user with matching id is found.
        return user;
    }

    @GET
    @Path("{id}/followers/")
    public User[] getFollowers(final @PathParam("id") int userId) {
        return  new User[5];
    }

    @GET
    @Path("{id}/follows/")
    public User[] getFollows(final @PathParam("id") int userId) {
        return new User[3];
    }

    @GET
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();

        try {

            Statement stmt = this.userConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                User currUser = new User(rs.getInt(1), rs.getString(2));
                users.add(currUser);
            }
//            this.userConnection.close();

        } catch (SQLException e) {
            System.out.println(e.getStackTrace().toString());
        }
        return users;
    }
}
