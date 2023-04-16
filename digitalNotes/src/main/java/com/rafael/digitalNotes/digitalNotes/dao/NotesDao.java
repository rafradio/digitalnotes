package com.rafael.digitalNotes.digitalNotes.dao;

import com.rafael.digitalNotes.digitalNotes.models.Note;
import com.rafael.digitalNotes.digitalNotes.models.TypeOfNote;
import java.util.ArrayList;
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
    
    public List<Note> mainForNote(){
        this.notes = jdbcTemplate.query("select * from notes", new NoteMapper());
        return this.notes;
    }
}
