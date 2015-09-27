package com.dwview.profileviewer.storage;

import com.dwview.profileviewer.db.MockViewDataAccessAPIImplementation;
import com.dwview.profileviewer.db.ViewDataAccessAPI;
import com.dwview.profileviewer.representations.View;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by Alberto on 2015-09-26.
 */
public class MockViewDataAccessAPIImplementationTest {

    @Test
    public void createSuccesfulView(){
        ViewDataAccessAPI viewDataAccessAPI = new MockViewDataAccessAPIImplementation();
        View view = new View(10, 10, DateTime.now());
        viewDataAccessAPI.createView(view);

        assertFalse(viewDataAccessAPI.listViews(10).isEmpty());
    }

    @Test
    public void listViewsWithOneElement(){
        ViewDataAccessAPI viewDataAccessAPI = new MockViewDataAccessAPIImplementation();
        View view = new View(10, 10, DateTime.now());
        viewDataAccessAPI.createView(view);

        assertFalse(viewDataAccessAPI.listViews(10).isEmpty());
        View retrievedView = viewDataAccessAPI.listViews(10).get(0);
        assertTrue(view.equals(retrievedView));
    }
    @Test
    public void listViewsWithMoreElementsForId(){
        ViewDataAccessAPI viewDataAccessAPI = new MockViewDataAccessAPIImplementation();
        View view = new View(10, 10, DateTime.now());
        View view2 = new View(10, 11, DateTime.now());
        viewDataAccessAPI.createView(view);
        viewDataAccessAPI.createView(view2);

        assertFalse(viewDataAccessAPI.listViews(10).isEmpty());
        assertTrue(viewDataAccessAPI.listViews(10).size() == 2);
    }

    @Test
    public void noListAvailableForId(){
        ViewDataAccessAPI viewDataAccessAPI = new MockViewDataAccessAPIImplementation();
        List<View> elements = viewDataAccessAPI.listViews(10);

        assertNull(elements);
    }

}