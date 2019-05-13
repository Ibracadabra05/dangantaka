package io.ibrah.com;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public int getId(){
        return this.id;
    }

    @JsonProperty
    public String getName(){
        return this.name;
    }

}