package com.dwview.profileviewer.representations;

/**
 * Created by Alberto on 2015-09-26.
 */
public class View {
    private final long viewerId;
    private final String DateTime;

    public View(long viewerId, String dateTime) {
        this.viewerId = viewerId;
        DateTime = dateTime;
    }

    public long getViewerId() {
        return viewerId;
    }

    public String getDateTime() {
        return DateTime;
    }
}
