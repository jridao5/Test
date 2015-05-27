/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.stage.Stage;

/**
 *
 * @author jridao5
 */
public class TextWriter extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
        try 
        {
 
            String content = "This is the content to write into file";

            File file = new File("/Users/jridao5/Documents/TextTest");

            // if file doesnt exists, then create it
            if (!file.exists()) 
            {
                file.createNewFile();
            }
 
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            
            try (BufferedWriter bw = new BufferedWriter(fw)) 
            {
                bw.write(content);
            }
 
            System.out.println("Done");
 
        } 
        catch (IOException e) {}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
