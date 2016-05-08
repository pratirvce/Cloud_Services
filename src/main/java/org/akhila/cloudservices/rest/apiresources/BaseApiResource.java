package org.akhila.cloudservices.rest.apiresources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.core.Response;

public abstract class BaseApiResource {
    protected Response generate404Response(String message) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return Response.status(404).entity(gson.toJson(message)).build();
    }

    protected Response genarate200Response(Object rawResponse, String callback) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (callback != null && callback.length() > 0) {
            return Response.status(200).entity(callback + "(" + gson.toJson(rawResponse) + ")").build();
        } else {
            return Response.status(200).entity(gson.toJson(rawResponse)).build();
        }
    }
}
