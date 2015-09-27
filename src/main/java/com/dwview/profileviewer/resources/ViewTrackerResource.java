package com.dwview.profileviewer.resources;

import com.codahale.metrics.annotation.Timed;
import com.dwview.profileviewer.db.ViewDataAccessAPI;
import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.representations.ViewDataRequest;
import io.dropwizard.hibernate.UnitOfWork;
import org.joda.time.DateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by alberto on 2015-09-25.
 */

@Path("/view")
@Produces(MediaType.APPLICATION_JSON)
public class ViewTrackerResource {

    private final ViewDataAccessAPI viewDataAccessAPI;

    public ViewTrackerResource(ViewDataAccessAPI viewDataAccessAPI) {
        this.viewDataAccessAPI = viewDataAccessAPI;
    }

    @PUT
    @Path("/{id}")
    @Timed
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewView(@PathParam("id")long id,ViewDataRequest dataRequest){
        DateTime date = DateTime.now();
        View view = new View(id, dataRequest.getViewerId(),date);
        viewDataAccessAPI.createView(view);
        return Response.status(201).build();
    }
}
