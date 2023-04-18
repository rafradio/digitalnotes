
package com.rafael.digitalNotes.digitalNotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
public class Note {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "type")
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("id=").append(this.getId())
                .append(", ")
                .append("type=").append(this.getType())
                .append(", ")
                .append("title=").append(this.getTitle())
                .append(", ")
                .append("body=").append(this.getBody())
                .append(", ")
                .append("date=").append(this.getDate());
        return sb.toString();
    }
    
    
}
