
package com.rafael.digitalNotes.digitalNotes.dao;

import com.rafael.digitalNotes.digitalNotes.models.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;


public class NoteMapper implements RowMapper<Note> {
    
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        Note note = new Note();
        note.setId(rs.getInt("id"));
        note.setType(rs.getInt("type"));
        note.setTitle(rs.getString("title"));
        note.setBody(rs.getString("body"));
        Timestamp timestamp = rs.getTimestamp("date");
        java.util.Date date = null;
        if (timestamp != null) {
            date = new java.util.Date(timestamp.getTime());
        }
//        note.setDate(rs.getDate("date"));
        note.setDate(date);
        return note;
    }
}
