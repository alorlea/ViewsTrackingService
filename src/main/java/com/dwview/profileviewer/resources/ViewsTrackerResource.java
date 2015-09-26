package com.dwview.profileviewer.resources;

import com.dwview.profileviewer.storage.DataStore;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ViewsTrackerResource {
    private final DataStore dataStore;

    public ViewsTrackerResource(DataStore dataStore) {
        this.dataStore = dataStore;
    }
}
