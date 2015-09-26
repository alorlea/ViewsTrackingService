package com.dwview.profileviewer.resources;

import com.dwview.profileviewer.storage.DataStore;
import com.dwview.profileviewer.storage.MockDataStoreImplementation;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ViewsTrackerResourceTest {

    private static DataStore dataStore = new MockDataStoreImplementation();
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ViewsTrackerResource(dataStore))
            .build();

    @Test
    public void getListOfViewersForViewId(){
        Response response = resources.client().target("/views/10").request().get();

        assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        assertEquals(response.getStatus(),200);
    }

}