package com.dwview.profileviewer.resources;

import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.storage.DataStore;
import com.dwview.profileviewer.storage.MockDataStoreImplementation;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ViewsTrackerResourceTest {

    private static DataStore dataStore = new MockDataStoreImplementation();
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ViewsTrackerResource(dataStore))
            .build();

    @Before
    public void setup(){
        dataStore.createView(5,new View(10, DateTime.now().toString()));
    }

    @Test
    public void getListOfViewersForViewId(){
        Response response = resources.client().target("/views/5").request().get();

        assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        assertEquals(response.getStatus(), 200);
        List<View> values = response.readEntity(new GenericType<List<View>>(){});

        assertFalse(values.isEmpty());
    }

}