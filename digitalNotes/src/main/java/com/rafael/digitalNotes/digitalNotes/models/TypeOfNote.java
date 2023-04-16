
package com.rafael.digitalNotes.digitalNotes.models;

import java.util.Date;


public class TypeOfNote {
    private int id;
    private String typename;
    private String icon;
    private String color;
    private Date date;

    public TypeOfNote() {
    }

    public TypeOfNote(int id, String typename, String icon, String color, Date date) {
        this.id = id;
        this.typename = typename;
        this.icon = icon;
        this.color = color;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTypename() {
        return typename;
    }

    public String getIcon() {
        return icon;
    }

    public String getColor() {
        return color;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
