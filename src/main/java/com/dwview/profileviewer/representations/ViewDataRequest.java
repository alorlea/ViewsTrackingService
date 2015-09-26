package com.dwview.profileviewer.representations;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alberto on 2015-09-25.
 */
public class ViewDataRequest {

    private long viewerId;

    public ViewDataRequest(){}

    public ViewDataRequest(long viewerId) {
        this.viewerId = viewerId;
    }

    @JsonProperty
    public long getViewerId() {
        return viewerId;
    }
}
