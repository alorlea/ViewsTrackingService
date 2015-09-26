package com.dwview.profileviewer.resources;

import com.codahale.metrics.annotation.Timed;
import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.storage.DataStore;

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
    private final DataStore dataStore;

    public ViewsTrackerResource(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GET
    @Path("/{id}")
    @Timed
    public List<View> listViews(@PathParam("id") long id){
        List<View> retrievedViews = dataStore.listViews(id);
        return retrievedViews;
    }
}
