package com.dwview.profileviewer.db;

import com.dwview.profileviewer.representations.View;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ViewDAO extends AbstractDAO<View> implements ViewDataAccessAPI{

    public ViewDAO(SessionFactory factory){
        super(factory);
    }
    @Override
    public View createView(View view) {
        return persist(view);
    }

    @Override
    public List<View> listViews(long viewerId) {
        return list(namedQuery("view.findRecentViews").setLong(0,viewerId));
    }
}
