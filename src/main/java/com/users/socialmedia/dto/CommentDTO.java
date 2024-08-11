package com.users.socialmedia.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable {
    private String text;
    private String date;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String text, String date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
