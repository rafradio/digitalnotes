package com.rafael.digitalNotes.digitalNotes.printToFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;

@Component
public class SaveToJson implements SaveToFile {

    @Override
    public void printTofile(String data, String id) {
        String fileName = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\data_json\\note_id_" + id + ".json";
        Path path = Paths.get(fileName);
        try 
            {  
                Path p = Files.createFile(path);   
            } 
        catch (IOException e) {}
        
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(data);
            myWriter.close();
        }
        catch (IOException e) {}  
        
        System.out.println("hello ajax " + data);
    }
    
}

