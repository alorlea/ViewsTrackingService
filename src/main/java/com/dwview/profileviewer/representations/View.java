package com.dwview.profileviewer.representations;

import com.dwview.profileviewer.json.CustomViewDeserializer;
import com.dwview.profileviewer.json.CustomViewSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Database schema is created automatically by dropwizard
 *
 * CREATE TABLE view (
    ID BIGINT,
    DATETIME TIMESTAMP NOT NULL,
    USERID BIGINT NOT NULL,
    VIEWERID BIGINT NOT NULL
 );
 * Created by Alberto on 2015-09-26.
 */

@Entity
@Table(name = "view")
@NamedQueries({
        @NamedQuery(name = "view.findRecentViews", query = "select v from View v where v.userId = ? order by dateTime desc")})
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @JsonIgnore
    @Column(name="userID",nullable = false)
    private long userId;
    @Column(name="viewerID",nullable = false)
    private long viewerId;
    @Column(name="dateTime",nullable = false)
    @JsonSerialize(using = CustomViewSerializer.class)
    @JsonDeserialize(using = CustomViewDeserializer.class)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateTime;

    public View(){}

    public View(long userId, long viewerId, DateTime dateTime) {
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


    public DateTime getDateTime() {
        return dateTime;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof View)) return false;

        View view = (View) o;

        if (id != view.id) return false;
        if (userId != view.userId) return false;
        if (viewerId != view.viewerId) return false;
        return !(dateTime != null ? !dateTime.equals(view.dateTime) : view.dateTime != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (viewerId ^ (viewerId >>> 32));
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
