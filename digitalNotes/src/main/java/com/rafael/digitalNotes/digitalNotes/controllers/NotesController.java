
package com.rafael.digitalNotes.digitalNotes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rafael.digitalNotes.digitalNotes.dao.NotesDao;
import com.rafael.digitalNotes.digitalNotes.dao.TypesDao;
import com.rafael.digitalNotes.digitalNotes.models.Note;
import com.rafael.digitalNotes.digitalNotes.models.TypeOfNote;
import com.rafael.digitalNotes.digitalNotes.printToFiles.SaveToFile;
import com.rafael.digitalNotes.digitalNotes.printToFiles.SaveToJson;
import jakarta.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
//import org.json.*;

@Controller
public class NotesController {
    private NotesDao notesDao;
    private TypesDao typesDao;
    private SaveToFile saveToFile;
    
    @Autowired
    public NotesController(NotesDao notesDao, TypesDao typesDao, SaveToJson saveToFile) {
        this.notesDao = notesDao;
        this.typesDao = typesDao;
        this.saveToFile = saveToFile;
    }
    
    @GetMapping("/notes")
    public String mainPage(Model model) {
        List<Note> notes = new ArrayList<>();
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
        List<Note> notes = this.notesDao.mainForNote(id);
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
        this.notesDao.saveNote(note);
        System.out.println("Hello Spring: " + note.getType());
        return "redirect:/index";
    }
    
    @GetMapping("/note/{id}")
    public String showNote(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", this.notesDao.showNote(id));
        return "notes/edit"; 
    }
    
    @PostMapping("/ajaxpost")
    public String saveJson(HttpServletRequest request) {
        String data = request.getParameter("jsonData");
//        System.out.println("hello ajax " + note.getTitle());
        this.saveToFile.printTofile(request.getParameter("jsonData"), request.getParameter("id"));
        return "redirect:/index";
    }
    
    @ResponseBody
    @GetMapping("/fetchpost")
    public String serverRestApi(HttpServletRequest request){
        
        Note note = this.notesDao.showNote(Integer.parseInt(request.getParameter("id")));
        String data = note.toString();
        String json = "";
        ObjectMapper objectMapper = new ObjectMapper(); 
        try {
            json = objectMapper.writeValueAsString(note);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("hello json " + json);
        return json;
    }
    
    @PostMapping("/{id}/edit")
    public String editNote(@ModelAttribute("note") Note note, @PathVariable("id") int id) {
        this.notesDao.editNote(note, id);
        return "redirect:/index";
    }
}
