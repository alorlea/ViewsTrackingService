package com.dwview.profileviewer.storage;

import com.dwview.profileviewer.representations.View;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by Alberto on 2015-09-26.
 */
public class MockDataStoreImplementationTest {

    @Test
    public void createSuccesfulView(){
        DataStore dataStore = new MockDataStoreImplementation();
        View view = new View(10, LocalDateTime.now().toString());
        dataStore.createView(10,view);

        assertFalse(dataStore.listViews(10).isEmpty());
    }

    @Test
    public void listViewsWithOneElement(){
        DataStore dataStore = new MockDataStoreImplementation();
        View view = new View(10, LocalDateTime.now().toString());
        dataStore.createView(10,view);

        assertFalse(dataStore.listViews(10).isEmpty());
        View retrievedView = dataStore.listViews(10).get(0);
        assertTrue(view.equals(retrievedView));
    }
    @Test
    public void listViewsWithMoreElementsForId(){
        DataStore dataStore = new MockDataStoreImplementation();
        View view = new View(10, LocalDateTime.now().toString());
        View view2 = new View(11, LocalDateTime.now().toString());
        dataStore.createView(10,view);
        dataStore.createView(10,view2);

        assertFalse(dataStore.listViews(10).isEmpty());
        assertTrue(dataStore.listViews(10).size() == 2);
    }

    @Test
    public void noListAvailableForId(){
        DataStore dataStore = new MockDataStoreImplementation();
        List<View> elements = dataStore.listViews(10);

        assertNull(elements);
    }

}