
package com.rafael.digitalNotes.digitalNotes.dao;

import com.rafael.digitalNotes.digitalNotes.models.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class NoteMapper implements RowMapper<Note> {
    
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        Note note = new Note();
        note.setId(rs.getInt("id"));
        note.setType(rs.getInt("type"));
        note.setTitle(rs.getString("title"));
        note.setBody(rs.getString("body"));
        note.setDate(rs.getDate("date"));
        return note;
    }
}
