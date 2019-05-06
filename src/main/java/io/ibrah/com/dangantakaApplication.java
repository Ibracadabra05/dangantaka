package io.ibrah.com;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.ibrah.com.resources.UserResource;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class dangantakaApplication extends Application<dangantakaConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dangantakaApplication().run(args);
    }

    @Override
    public String getName() {
        return "dangantaka";
    }

    @Override
    public void initialize(final Bootstrap<dangantakaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dangantakaConfiguration configuration,
                    final Environment environment) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/website?user=Ibrahim&password=users");
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }

        environment.jersey().register(new UserResource(conn));

    }

}
