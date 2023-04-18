package com.rafael.digitalNotes.digitalNotes.dao;

import com.rafael.digitalNotes.digitalNotes.models.Note;
import com.rafael.digitalNotes.digitalNotes.models.TypeOfNote;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotesDao {
    private List<Note> notes = new ArrayList<>();
//    private List<TypeOfNote> typesOfNotes = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NotesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Note> mainForNote(int id){
        String sql = "select * from notes where type=" + id;
        this.notes = jdbcTemplate.query(sql, new NoteMapper());
        Collections.sort(this.notes, new Comparator() {
            public int compare(Object o1, Object o2) {
                return (((Note) o2).getDate().compareTo(((Note) o1).getDate()));
            }
        });
        return this.notes;
    }
    
    public void saveNote(Note note) {
        Date date = Calendar.getInstance().getTime(); 
        note.setDate(date);
        jdbcTemplate.update("insert into notes (type, title, body, date) values(?,?,?,?)",
                note.getType(), note.getTitle(), note.getBody(), note.getDate());
    }
        
    public Note showNote(int id) {
        return jdbcTemplate.query("SELECT * FROM notes WHERE id=?", new Object[]{id}, new NoteMapper())
            .stream().findAny().orElse(null);
        
    }
        
    public void editNote(Note note, int id) {
        Date date = Calendar.getInstance().getTime();
        note.setDate(date);
        System.out.println("Проверяем дату " + note.getDate() + "\n");
        jdbcTemplate.update("UPDATE notes SET title=?, body=?, date=? WHERE id=?",
                note.getTitle(), note.getBody(), note.getDate(), id);
        
    }
    
    public void deleteNote(int id) {
        jdbcTemplate.update("DELETE FROM notes WHERE id=?", id);
    }
}
