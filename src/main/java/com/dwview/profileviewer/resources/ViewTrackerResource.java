package com.dwview.profileviewer.resources;

import com.codahale.metrics.annotation.Timed;
import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.representations.ViewDataRequest;
import com.dwview.profileviewer.storage.DataStore;
import org.joda.time.LocalDateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by alberto on 2015-09-25.
 */

@Path("/view")
@Produces(MediaType.APPLICATION_JSON)
public class ViewTrackerResource {

    private final DataStore dataStore;

    public ViewTrackerResource(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @PUT
    @Path("/{id}")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewView(@PathParam("id")long id,ViewDataRequest dataRequest){
        LocalDateTime date = LocalDateTime.now();
        View view = new View(dataRequest.getViewerId(),date.toString());
        dataStore.createView(id,view);
        return Response.status(201).build();
    }
}
