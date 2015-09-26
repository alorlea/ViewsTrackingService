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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof View)) return false;

        View view = (View) o;

        if (viewerId != view.viewerId) return false;
        return !(DateTime != null ? !DateTime.equals(view.DateTime) : view.DateTime != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (viewerId ^ (viewerId >>> 32));
        result = 31 * result + (DateTime != null ? DateTime.hashCode() : 0);
        return result;
    }
}
