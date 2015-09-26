package com.dwview.profileviewer.storage;

import com.dwview.profileviewer.representations.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alberto on 2015-09-26.
 */
public class MockDataStoreImplementation implements DataStore {

    public Map<Long,List<View>> storage;

    public MockDataStoreImplementation(){
        this.storage = new ConcurrentHashMap<>();
    }

    @Override
    public void createView(long whoViewedId,View view) {
        if(storage.containsKey(whoViewedId)){
            storage.get(whoViewedId).add(view);
        }else{
            List<View> views = new ArrayList<>();
            views.add(view);
            storage.put(whoViewedId,views);
        }
    }

    @Override
    public List<View> listViews(long viewerId) {
        if(storage.containsKey(viewerId)){
            return storage.get(viewerId);
        }
        return null;
    }
}
