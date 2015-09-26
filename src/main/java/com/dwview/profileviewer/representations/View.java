package com.dwview.profileviewer.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Alberto on 2015-09-26.
 */
public class View {
    private long viewerId;
    private String dateTime;

    public View(){}
    
    public View(long viewerId, String dateTime) {
        this.viewerId = viewerId;
        this.dateTime = dateTime;
    }

    @JsonProperty
    public long getViewerId() {
        return viewerId;
    }

    @JsonProperty
    public String getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof View)) return false;

        View view = (View) o;

        if (viewerId != view.viewerId) return false;
        return !(dateTime != null ? !dateTime.equals(view.dateTime) : view.dateTime != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (viewerId ^ (viewerId >>> 32));
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
