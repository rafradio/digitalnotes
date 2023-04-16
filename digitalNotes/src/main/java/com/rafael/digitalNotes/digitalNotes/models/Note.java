
package com.rafael.digitalNotes.digitalNotes.models;

import java.util.Date;

public class Note {
    private int id;
    
    private int type;
    
    private String title;
    
    private String body;
    
    private Date date;

    public Note() {
        
    }

    public Note(int id, int type, String title, String body, Date date) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.body = body;
        this.date = date;

    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
