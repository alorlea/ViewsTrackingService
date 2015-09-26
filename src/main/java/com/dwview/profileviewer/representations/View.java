package com.dwview.profileviewer.representations;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Alberto on 2015-09-26.
 */

@Entity
@Table(name = "view")
@NamedQueries({
        @NamedQuery(name = "view.findRecentViews", query = "SELECT v FROM View v WHERE v.userId = ?")})
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @Column(name="userID",nullable = false)
    private long userId;
    @Column(name="viewerID",nullable = false)
    private long viewerId;
    @Column(name="dateTime",nullable = false)
    private String dateTime;

    public View(){}

    public View(long userId, long viewerId, String dateTime) {
        this.userId = userId;
        this.viewerId = viewerId;
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getViewerId() {
        return viewerId;
    }


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

    public long getUserId() {
        return userId;
    }
}
