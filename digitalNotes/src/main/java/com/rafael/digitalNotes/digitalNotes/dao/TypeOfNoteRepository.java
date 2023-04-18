
package com.rafael.digitalNotes.digitalNotes.dao;

import com.rafael.digitalNotes.digitalNotes.models.Note;
import com.rafael.digitalNotes.digitalNotes.models.TypeOfNote;
import org.springframework.data.repository.CrudRepository;

public interface TypeOfNoteRepository extends CrudRepository<TypeOfNote, Integer> {
    
}
