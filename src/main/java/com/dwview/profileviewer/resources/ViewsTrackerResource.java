package com.dwview.profileviewer.resources;

import com.codahale.metrics.annotation.Timed;
import com.dwview.profileviewer.db.ViewDataAccessAPI;
import com.dwview.profileviewer.representations.View;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Alberto on 2015-09-26.
 */

@Path("/views")
@Produces(MediaType.APPLICATION_JSON)
public class ViewsTrackerResource {
    private final ViewDataAccessAPI viewDataAccessAPI;

    public ViewsTrackerResource(ViewDataAccessAPI viewDataAccessAPI) {
        this.viewDataAccessAPI = viewDataAccessAPI;
    }

    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    public List<View> listViews(@PathParam("id") long id){
        List<View> retrievedViews = viewDataAccessAPI.listViews(id);
        return retrievedViews;
    }
}
