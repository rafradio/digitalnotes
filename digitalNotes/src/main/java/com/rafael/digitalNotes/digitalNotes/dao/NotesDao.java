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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotesDao {
    private List<Note> notes = new ArrayList<>();
//    private List<TypeOfNote> typesOfNotes = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    private NoteRepository noteRepository;

    @Autowired
    public NotesDao(JdbcTemplate jdbcTemplate, NoteRepository noteRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.noteRepository = noteRepository;
    }
    
    public List<Note> mainForNote(int id){
        List<Note> notes = (List<Note>) this.noteRepository.findAll();
        String sql = "select * from note where type=" + id;
//        this.notes = jdbcTemplate.query(sql, new NoteMapper());
        this.notes = notes.stream().filter(p -> p.getType() == id).collect(Collectors.toList());
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
        noteRepository.save(note);
//        jdbcTemplate.update("insert into note (type, title, body, date) values(?,?,?,?)",
//                note.getType(), note.getTitle(), note.getBody(), note.getDate());
    }
        
    public Note showNote(int id) {
        return jdbcTemplate.query("SELECT * FROM note WHERE id=?", new Object[]{id}, new NoteMapper())
            .stream().findAny().orElse(null);
        
    }
        
    public void editNote(Note note, int id) {
        Date date = Calendar.getInstance().getTime();
        note.setDate(date);
        System.out.println("Проверяем дату " + note.getDate() + "\n");
        jdbcTemplate.update("UPDATE note SET title=?, body=?, date=? WHERE id=?",
                note.getTitle(), note.getBody(), note.getDate(), id);
        
    }
    
    public void deleteNote(int id) {
        jdbcTemplate.update("DELETE FROM note WHERE id=?", id);
    }
}
