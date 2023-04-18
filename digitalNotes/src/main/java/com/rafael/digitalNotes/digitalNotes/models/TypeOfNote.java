
package com.rafael.digitalNotes.digitalNotes.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
public class TypeOfNote {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String typename;
    private String icon;
    private String color;
    private Date date;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany
    @JoinColumn(name = "type")
    private Set<Note> notes;
    
//    @JoinColumn(name = "note_id", referencedColumnName = "id")
//    private Note note;
//    private Set<Note> notes;

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
