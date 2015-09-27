package com.dwview.profileviewer.resources;

import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.db.ViewDataAccessAPI;
import com.dwview.profileviewer.db.MockViewDataAccessAPIImplementation;
import com.dwview.profileviewer.util.FilterBasedRules;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ViewsTrackerResourceTest {

    private static ViewDataAccessAPI viewDataAccessAPI = new MockViewDataAccessAPIImplementation();
    private static FilterBasedRules rules = new FilterBasedRules();
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ViewsTrackerResource(viewDataAccessAPI,rules))
            .build();

    @Before
    public void setup(){
        viewDataAccessAPI.createView(new View(5, 10, DateTime.now()));
        viewDataAccessAPI.createView(new View(6, 10, DateTime.now().minusDays(12)));
    }

    @Test
    public void getListOfViewersForViewId(){
        Response response = resources.client().target("/views/5").request().get();

        assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        assertEquals(response.getStatus(), 200);
        List<View> values = response.readEntity(new GenericType<List<View>>(){});

        assertFalse(values.isEmpty());
    }

    @Test
    public void getListOfViewersForViewIdOldDays(){
        Response response = resources.client().target("/views/6").request().get();

        assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        assertEquals(response.getStatus(), 200);
        List<View> values = response.readEntity(new GenericType<List<View>>(){});

        assertTrue(values.isEmpty());
    }

}