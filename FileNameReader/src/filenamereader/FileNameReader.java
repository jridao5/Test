/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filenamereader;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Willy
 */
public class FileNameReader extends Application 
{
 
    /*public static void main(String[] args) 
    {
        launch(args);
    }*/
    
    @Override
    public void start(Stage primaryStage) throws IOException 
    {   
        File folder = new File("/Users/thejuandesire/Documents/Rafael/Test/Movies"); //makes a path to the specified folder
        File[] listOfFiles = folder.listFiles(); //makes an arrayList of file objects
        
        for (File movie : listOfFiles)
        {
                String title = movie.getName().substring(0,movie.getName().indexOf("("));
                System.out.println("Title: " + title); //title.getName() gets the title of the file
        }
    }
}