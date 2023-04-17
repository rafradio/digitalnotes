package com.rafael.digitalNotes.digitalNotes.printToFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SaveToJson implements SaveToFile {
    public final Environment environment;

    public SaveToJson(Environment environment) {
        this.environment = environment;
    }
    
    @Override
    public void printTofile(String data, String id) {
        String fileName1 = this.environment.getProperty("path_onserver") + id + ".json";
        Path path = Paths.get(fileName1);
        try 
            {  
                Path p = Files.createFile(path);   
            } 
        catch (IOException e) {}
        
        try {
            FileWriter myWriter = new FileWriter(fileName1);
            myWriter.write(data);
            myWriter.close();
        }
        catch (IOException e) {}  
        
        System.out.println("hello ajax " + data);
    }
    
}

