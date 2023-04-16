package com.rafael.digitalNotes.digitalNotes.dao;

import com.rafael.digitalNotes.digitalNotes.models.TypeOfNote;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TypesDao {
    private List<TypeOfNote> typesOfNotes = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public TypesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<TypeOfNote> mainForType(){
        return jdbcTemplate.query("select * from notetypes", new TypeMapper());
    }
    
}
