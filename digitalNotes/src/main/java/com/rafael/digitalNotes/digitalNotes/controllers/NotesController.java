
package com.rafael.digitalNotes.digitalNotes.controllers;

import com.rafael.digitalNotes.digitalNotes.dao.NotesDao;
import com.rafael.digitalNotes.digitalNotes.dao.TypesDao;
import com.rafael.digitalNotes.digitalNotes.models.Note;
import com.rafael.digitalNotes.digitalNotes.models.TypeOfNote;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotesController {
    private NotesDao notesDao;
    private TypesDao typesDao;
    
    @Autowired
    public NotesController(NotesDao notesDao, TypesDao typesDao) {
        this.notesDao = notesDao;
        this.typesDao = typesDao;
    }
    
    @GetMapping("/notes")
    public String mainPage(Model model) {
        List<Note> notes = this.notesDao.mainForNote();
        model.addAttribute("notes", notes);
        return "notes/main";
    }
    
    @GetMapping("/index")
    public String indexPage(Model model) {
        List<TypeOfNote> types = this.typesDao.mainForType();
        model.addAttribute("types", types);
        System.out.println("Hello world: " + types.get(1).getTypename());
        return "notes/index";
    }
    
    @GetMapping("/notes/{id}")
    public String showNotes(@PathVariable("id") int id, Model model) {
        List<Note> notes = new ArrayList<>();
        model.addAttribute("notes", notes);
        return "notes/main";
    }
    
    @GetMapping("/new")
    public String showNew(Model model) {
        List<TypeOfNote> types = this.typesDao.mainForType();
//        List<String> typesName = types.stream().map(p -> p.getTypename()).collect(Collectors.toList());
        model.addAttribute("note", new Note());
        model.addAttribute("typesName", types);
        String route = "notes/new";
        return route;
    }
    
    @PostMapping("/new")
    public String createNote(@ModelAttribute("note") Note note) {
//        this.notesDao.saveNote(note);
        System.out.println("Hello Spring: " + note.getType());
        return "redirect:/index";
    }
}
