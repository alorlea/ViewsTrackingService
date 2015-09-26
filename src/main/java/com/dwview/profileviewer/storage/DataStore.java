package com.dwview.profileviewer.storage;

import com.dwview.profileviewer.representations.View;

import java.util.List;

/**
 * Created by Alberto on 2015-09-26.
 */
public interface DataStore {
    public void createView(long whoViewedId,View view);
    public List<View> listViews(long viewerId);
}
