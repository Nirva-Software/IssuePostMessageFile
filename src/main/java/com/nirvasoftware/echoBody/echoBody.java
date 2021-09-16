package com.nirvasoftware.echoBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/echo")
public class echoBody {

    private static final int MAX_RES = 100_000;
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/body")
    public String echo(String requestBody) {
        String res = "";
        if (requestBody != null) {
            if (requestBody.length() > MAX_RES) {
                res = requestBody.substring(0, MAX_RES);
            } else {
                res = requestBody;
            }
        }

        return res;
    }
}
