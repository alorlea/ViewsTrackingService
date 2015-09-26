package com.dwview.profileviewer.db;

import com.dwview.profileviewer.representations.View;

import java.util.List;

/**
 * Created by Alberto on 2015-09-26.
 */
public interface ViewDataAccessAPI {
    public View createView(View view);
    public List<View> listViews(long viewerId);
}
