package com.dwview.profileviewer.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alberto on 2015-09-25.
 */
public class View {

    private long viewerId;

    public View(){}

    public View(long viewerId) {
        this.viewerId = viewerId;
    }

    @JsonProperty
    public long getViewerId() {
        return viewerId;
    }
}
