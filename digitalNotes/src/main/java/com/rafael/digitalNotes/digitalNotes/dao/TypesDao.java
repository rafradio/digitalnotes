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
    private TypeOfNoteRepository typeOfNoteRepository;
    
    @Autowired
    public TypesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<TypeOfNote> mainForType(){
        List<TypeOfNote> types = (List<TypeOfNote>) this.typeOfNoteRepository.findAll();
        if (types.isEmpty()) {
            TypeOfNote typeOfNote = new TypeOfNote();
            typeOfNote.setTypename("личные");
            typeOfNote.setColor("red");
            typeOfNoteRepository.save(typeOfNote);
//            jdbcTemplate.update("insert into type_of_note (typename, color) values(?,?)",
//                "рабочие", "blue");
            TypeOfNote typeOfNote1 = new TypeOfNote();
            typeOfNote1.setTypename("рабочие");
            typeOfNote1.setColor("blue");
            typeOfNoteRepository.save(typeOfNote1);
            System.out.println("Проверяем entity ");
        }
        return jdbcTemplate.query("select * from type_of_note", new TypeMapper());
    }
    
}
