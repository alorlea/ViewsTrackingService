package com.dwview.profileviewer.db;

import com.dwview.profileviewer.representations.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alberto on 2015-09-26.
 */
public class MockViewDataAccessAPIImplementation implements ViewDataAccessAPI {

    public Map<Long,List<View>> storage;

    public MockViewDataAccessAPIImplementation(){
        this.storage = new ConcurrentHashMap<>();
    }

    @Override
    public View createView(View view) {
        if(storage.containsKey(view.getUserId())){
            List<View> views = storage.get(view.getUserId());
            views.add(view);
        }else{
            List<View> views = new ArrayList<>();
            views.add(view);
            storage.put(view.getUserId(),views);
        }
        return view;
    }

    @Override
    public List<View> listViews(long viewerId) {
        List<View> views = null;
        if(storage.containsKey(viewerId)){
            views = storage.get(viewerId);
        }
        return views;
    }
}
