package com.users.socialmedia.domain;

import java.util.Date;

public class Post {
    private String id;
    private Date date;
    private String title;
    private String body;

    public Post() {
    }

    public Post(String id, Date date, String title, String body) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Post)) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}