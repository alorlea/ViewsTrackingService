package com.dwview.profileviewer.resources;

import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.representations.ViewDataRequest;
import com.dwview.profileviewer.db.ViewDataAccessAPI;
import com.dwview.profileviewer.db.MockViewDataAccessAPIImplementation;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewTrackerResourceTest {

    private static ViewDataAccessAPI viewDataAccessAPI = new MockViewDataAccessAPIImplementation();
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ViewTrackerResource(viewDataAccessAPI))
            .build();

    @Before
    public void setup(){
        viewDataAccessAPI.createView(new View(10, 10, DateTime.now()));
    }

    @Test
    public void createNewViewForUser(){
        ViewDataRequest request = new ViewDataRequest(10);
        Response response = resources.client().target("/view/10").request(MediaType.APPLICATION_JSON_TYPE).put(Entity
                .json(request));
        assertEquals(response.getStatus(),201);

    }

    @Test
    public void createNewViewForUserAndStored(){
        ViewDataRequest request = new ViewDataRequest(10);
        Response response = resources.client().target("/view/10").request(MediaType.APPLICATION_JSON_TYPE).put(Entity
                .json(request));
        assertEquals(response.getStatus(),201);

        //Check that the element is in the dataStore, and as it is new, only one element in the list

        List<View> views = viewDataAccessAPI.listViews(10);
        View view = views.get(0);

        assertEquals(view.getViewerId(),10);
        assertNotNull(view.getDateTime());
    }

}