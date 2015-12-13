package com.leeavital.tracewizard;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by lee on 11/8/15.
 */
@Path("/api")
public class CollectResource {

    @Path("/collect")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void collect(List<TraceSpan> spans) {
        System.out.println(spans);
    }

}
