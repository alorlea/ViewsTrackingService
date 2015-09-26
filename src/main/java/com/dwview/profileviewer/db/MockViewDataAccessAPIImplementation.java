package com.dwview.profileviewer.db;

import com.dwview.profileviewer.representations.View;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
            Collections.sort(views, (o1, o2) -> {
                DateTime o1Date = new DateTime(o1.getDateTime());
                DateTime o2Date = new DateTime(o1.getDateTime());
                return DateTimeComparator.getInstance().compare(o1Date,o2Date);
            });
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
            views = views.stream().filter(view ->
                    (new DateTime(view.getDateTime())).isBefore(DateTime.now().plusDays(10)))
                    .limit(10)
                    .collect(Collectors.toList());
        }
        return views;
    }
}
