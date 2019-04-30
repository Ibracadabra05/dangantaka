package io.ibrah.com;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class User {

    public User() {

    }

    @JsonProperty
    public int getId(){
        return 1;
    }

    @JsonProperty
    public String getName(){
        return "Ibrah";
    }

}